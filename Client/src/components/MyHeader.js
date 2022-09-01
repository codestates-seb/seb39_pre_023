import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import styled from 'styled-components';
import { faStackOverflow } from '@fortawesome/fontawesome-free-brands';
import { faBars, faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';
import MyButton from './MyButton';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';
import { useState } from 'react';
// import { useSelector } from 'react-redux';
/* eslint-disable react/prop-types */
axios.defaults.withCredentials = false;

const MyHeader = ({ viewModal, setModal }) => {
  // const state = useSelector((state) => state.signInReducer);
  const navigate = useNavigate();
  const [isLogin, setIsLogin] = useState(true);
  const viewLogout = () => {
    setModal(!viewModal);
  };
  return (
    <Container>
      <FontAwesomeIcon
        icon={faBars}
        className="menubar"
        onClick={() => {
          setIsLogin(!isLogin);
        }}
      />
      <Wrapper>
        <Logo
          onClick={() => {
            navigate('/');
          }}
        >
          <FontAwesomeIcon
            icon={faStackOverflow}
            className={isLogin ? 'loginLogo' : ''}
          />
          Stack<b>Overflow</b>
        </Logo>
        <div className={isLogin ? 'loginHardcoding' : 'hardcoding'}>
          <span className={isLogin ? 'displayNone' : ''}>About</span>
          <span>Products</span>
          <span className={isLogin ? 'displayNone' : ''}>For Teams</span>
        </div>
        <form className={isLogin ? 'loginSearch' : ''}>
          <FontAwesomeIcon icon={faMagnifyingGlass} className="magnifying" />
          <input type="text" placeholder="Search..." />
        </form>
        <BtnWapper>
          {isLogin ? (
            <>
              <Link
                to="/mypage"
                style={{ textDecoration: 'none' }}
                className="loginMypage"
              >
                <span>Mypage</span>
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
          className={isLogin ? 'menubar loginMenubar' : 'displayNone'}
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
    width: 3%;
  }
  .loginHardcoding {
    width: 3%;
  }
  .loginLogo {
    width: 10%;
  }
  .loginSearch {
    width: 70%;
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
    margin-left: 10px;
    cursor: pointer;
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
  margin: 0 10px;
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
