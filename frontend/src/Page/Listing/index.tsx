import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/request";

function Listing() {
  // o react ele tem circulo de requsições com isso trabalhando com hooks podemos  vincular com o circulo do react !

  /*Hook: useState
Manter estado no componente */

  const [pageNumber, setPageNumber] = useState(0);

  const [page, setPage] = useState<MoviePage>({
    content: [],
    last: true,
    totalPages: 0,
    totalElements: 0,
    size: 12,
    number: 0,
    first: true,
    numberOfElements: 0,
    empty: true,
  });

  /*Hook: useEffect
Executar algo na instanciação ou destruição do componente, observar estado */

  useEffect(() => {
    axios
      .get(`${BASE_URL}/movies?size=12&page=${pageNumber}&sort=id`)
      .then((response) => {
        const data = response.data as MoviePage;
        setPage(data);
        console.log(data)
      });
    
  }, [pageNumber]);

  /*fomra errada
    axios.get(`${BASE_URL}/movies?size=12&page=0`).then((response) => {
    console.log(response.data);*/

    const habdlePageChabge = (newPagenumber : number) => {
      setPageNumber(newPagenumber);
    }

  return (
    <>
      <Pagination page={page } onChange={habdlePageChabge} />

      <div className="container">
        <div className="row">
          {page.content.map((movie) => {
            return (
              <div key={movie.id} className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                <MovieCard movie={movie} />
              </div>
            );
          })}
        </div>
      </div>
    </>
  );
}

export default Listing;
