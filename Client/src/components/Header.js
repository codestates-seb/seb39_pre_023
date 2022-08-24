import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import styled from 'styled-components';
import { faStackOverflow } from '@fortawesome/fontawesome-free-brands';

const StyledHeader = styled.header`
  background-color: #f8f8f9;
  box-shadow: 0px 3px 3px rgba(0, 0, 0, 0.2);
  display: grid;
  grid-template-columns: 200px 1fr 200px;
`;

const LogoLink = styled.a`
  color: black;
  text-decoration: none;
  display: inline-block;
  height: 50px;
  line-height: 50px;
  padding: 0 15px;
  b {
    font-weight: bold;
  }
`;

const Header = () => {
  return (
    <StyledHeader>
      <LogoLink className="logo">
        <FontAwesomeIcon icon={faStackOverflow} />
        Stack<b>OverFlow</b>
      </LogoLink>
      <form action="" className="search">
        <input type="text" placeholder="Search..." />
      </form>
    </StyledHeader>
  );
};

export default Header;
