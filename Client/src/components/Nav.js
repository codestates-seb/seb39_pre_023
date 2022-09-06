import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEarthAmerica } from '@fortawesome/free-solid-svg-icons';

const StyledNav = styled.div`
  @import url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');
  font-family: Roboto, sans-serif;
  color: black;
  display: flex;
  flex-direction: column;
  margin-top: 3px;
  height: 100vh;
  width: 164px;

  ol {
    margin-top: 30px;
    padding-left: 10px;
    list-style: none;
    padding-bottom: 20px;
  }
  li {
    margin-top: 0px;
    margin: 20px;
  }
  div {
    padding-bottom: 20px;
  }
  a {
    margin-top: 20px;
    padding-top: 10px;
    text-decoration-line: none;
    color: black;
  }
  .question {
    margin-left: 1px;
  }
  .earth {
    padding: 0 1px 1px;
  }
`;

function Nav() {
  return (
    <StyledNav>
      <Link to="/">Home</Link>
      <ol>
        Public
        <li className="question">
          <Link to="/">
            <FontAwesomeIcon className="earth" icon={faEarthAmerica} />
            Questions
          </Link>
        </li>
        <li>
          <Link to="/tags">Tags</Link>
        </li>
        <li>
          <Link to="/users">Users</Link>
        </li>
        <li>
          <Link to="/companies">Companies</Link>
        </li>
      </ol>
    </StyledNav>
  );
}

export default Nav;
