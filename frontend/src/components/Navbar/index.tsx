import { ReactComponent as GithubIcon } from "assets/img/Vector.svg";

import './styles.css'

function Navbar() {
  return (
    <header>
      <nav className="container">
        <div className="dsmovie-nav-content">
          <h1>Movie</h1>
          <a href="https://github.com/EudesGomes017/Project-Movies">
            
            <div className="dsmovie-contact-container">
              <GithubIcon />
              <p>DLEAWEBSYSTEM</p>
            </div>
          </a>
        </div>
      </nav>
    </header>
  );
}

export default Navbar;
