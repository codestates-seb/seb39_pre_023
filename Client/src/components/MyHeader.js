import styled from 'styled-components';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faStackOverflow } from '@fortawesome/fontawesome-free-brands';
import { faBars, faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';
import MyButton from './MyButton';
import { useNavigate, Link } from 'react-router-dom';
import { useSelector } from 'react-redux';
/* eslint-disable react/prop-types */

const MyHeader = ({ viewModal, setModal }) => {
  const state = useSelector((state) => state.signInReducer);
  const data = localStorage.getItem('userid');
  let userid = JSON.parse(data);
  const navigate = useNavigate();
  const viewLogout = () => {
    setModal(!viewModal);
  };
  return (
    <Container>
      <Wrapper>
        <Logo
          onClick={() => {
            navigate('/');
          }}
        >
          <FontAwesomeIcon
            icon={faStackOverflow}
            className={state.loginState ? 'loginLogo' : ''}
          />
          Stack<b>Overflow</b>
        </Logo>
        <div className={state.loginState ? 'loginHardcoding' : 'hardcoding'}>
          <span className={state.loginState ? 'displayNone' : ''}>About</span>
          <span>Products</span>
          <span className={state.loginState ? 'displayNone' : ''}>
            For Teams
          </span>
        </div>
        <form className={state.loginState ? 'loginSearch' : ''}>
          <FontAwesomeIcon icon={faMagnifyingGlass} className="magnifying" />
          <input type="text" placeholder="Search..." />
        </form>
        <BtnWapper>
          {state.loginState ? (
            <>
              <Link
                to="/mypage"
                style={{ textDecoration: 'none' }}
                className="loginMypage"
              >
                <span className="loginMypage">{userid.userid}&apos;s page</span>
              </Link>
            </>
          ) : (
            <>
              <MyButton
                text={`Log in`}
                type={'skyblue'}
                onClick={() => {
                  navigate('/login');
                }}
              />
              <MyButton
                text={`Sign up`}
                type={'blue'}
                onClick={() => {
                  navigate('/signup');
                }}
              />
            </>
          )}
        </BtnWapper>
        <FontAwesomeIcon
          icon={faBars}
          className={state.loginState ? 'menubar loginMenubar' : 'displayNone'}
          onClick={viewLogout}
        />
      </Wrapper>
    </Container>
  );
};
const Container = styled.header`
  background-color: #f8f9f9;
  border-top: solid 3px #f2740d;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
  display: flex;
  justify-content: center;
  padding: 10px;
  .displayNone {
    display: none;
  }
  .loginMenubar {
    width: 3%;
  }
  .loginMypage {
    width: 5%;
    white-space: nowrap;
  }
  .loginHardcoding {
    width: 5%;
  }
  .loginLogo {
    width: 15%;
  }
  .loginSearch {
    width: 65%;
  }
`;
const Wrapper = styled.div`
  width: 1330px;
  display: flex;
  align-items: center;
  justify-content: space-around;
  height: 30px;
  .menubar {
    width: 2%;
    font-size: 16px;
    padding: 17px 10px;
    cursor: pointer;
  }
  .menubar:hover {
    background-color: #e3e6e8;
  }
  .hardcoding {
    display: flex;
    white-space: nowrap;
    padding: 10px;
    width: 18%;
    justify-content: space-around;
  }
  span {
    font-size: 14px;
    color: #363b3f;
    border-radius: 10px;
    padding: 5px 8px;
  }
  span:hover {
    background-color: #e3e6e8;
  }
  form {
    width: 55%;
    display: flex;
  }
  input {
    flex-basis: 100%;
    height: 30px;
    font-size: 14px;
    color: #363b3f;
    text-indent: 35px;
    border: 1px solid #8a939b;
  }
  input:focus {
    border: 1px solid cornflowerblue;
    border-radius: 2px;
    outline: none;
    box-shadow: 0 0 0 3px #cde9fe;
  }
  .magnifying {
    position: relative;
    left: 30px;
    top: 6px;
    color: #8a939b;
    font-size: 16px;
  }
  a {
    text-decoration: none;
  }
`;
const Logo = styled.div`
  width: 10%;
  color: black;
  display: flex;
  justify-content: center;
  font-size: 18px;
  cursor: pointer;
  padding: 15px 10px;
  &:hover {
    background-color: #e3e6e8;
  }
  b {
    font-weight: 800;
    padding-left: 5px;
  }
`;
const BtnWapper = styled.div`
  display: flex;
  button:first-of-type {
    margin: 0px 10px;
  }
  button:nth-of-type(2) {
    width: 80px;
  }
`;
export default MyHeader;
