import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import styled from 'styled-components';
import { faStackOverflow } from '@fortawesome/fontawesome-free-brands';
import { faBars, faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';
import MyButton from './MyButton';
import { useEffect, useState } from 'react';
import axios from 'axios';

const MyHeader = () => {
  const [data, setData] = useState('');
  useEffect(() => {
    axios
      .get(`115.40.230.109:8080/api/answer/1`)
      .then((res) => {
        setData(res.data);
        console.log(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  return (
    <Container>
      <FontAwesomeIcon icon={faBars} className="menubar" />
      <Logo>
        <FontAwesomeIcon icon={faStackOverflow} />
        Stack<b>Overflow</b>
      </Logo>
      <div className="hardcoding">
        <span>About</span>
        <span>Products</span>
        <span>For Teams</span>
      </div>
      <form>
        <FontAwesomeIcon icon={faMagnifyingGlass} className="magnifying" />
        <input type="text" placeholder="Search..." />
      </form>
      <BtnWapper>
        <MyButton text={`Log in`} type={'skyblue'} onClick={() => {}} />
        <MyButton text={`Sign up`} type={'blue'} onClick={() => {}} />
      </BtnWapper>
    </Container>
  );
};

const Container = styled.header`
  background-color: #f8f9f9;
  border-top: solid 3px #f2740d;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  .menubar {
    font-size: 20px;
    margin-left: 10px;
    cursor: pointer;
  }
  .hardcoding {
    display: flex;
    white-space: nowrap;
    padding: 10px;
  }
  span {
    margin: 0 20px;
    font-size: 18px;
    color: #363b3f;
  }
  input {
    width: 550px;
    height: 42px;
    font-size: 18px;
    color: #363b3f;
    text-indent: 35px;
  }
  input:focus {
    border: 1px solid cornflowerblue;
    border-radius: 2px;
    outline: none;
    box-shadow: 0 0 0 5px #cde9fe;
  }
  .magnifying {
    position: relative;
    left: 30px;
    color: gray;
    font-size: 20px;
  }
`;

const Logo = styled.div`
  color: black;
  display: flex;
  font-size: 25px;
  cursor: pointer;
  margin: 0 10px;
  b {
    font-weight: 800;
    padding-left: 5px;
  }
`;

const BtnWapper = styled.div`
  display: flex;
  justify-content: space-between;
  width: 150px;
`;
export default MyHeader;
