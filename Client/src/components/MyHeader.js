import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import styled from 'styled-components';
import { faStackOverflow } from '@fortawesome/fontawesome-free-brands';
import { faBars, faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';

const MyHeader = () => {
  return (
    <Container>
      <FontAwesomeIcon icon={faBars} />
      <Logo className="logo">
        <FontAwesomeIcon icon={faStackOverflow} />
        Stack<b>OverFlow</b>
      </Logo>
      <form className="search">
        <FontAwesomeIcon icon={faMagnifyingGlass} />
        <input type="text" placeholder="Search..." />
      </form>
      <button>Log in</button>
      <button>Sign up</button>
    </Container>
  );
};

const Container = styled.header`
  background-color: #f8f9f9;
  border-top: solid 3px #f2740d;
  box-shadow: 0px 3px 3px rgba(0, 0, 0, 0.2);
  display: flex;
`;

const Logo = styled.span`
  color: black;
  display: flex;
  b {
    font-weight: 700;
  }
`;

export default MyHeader;
