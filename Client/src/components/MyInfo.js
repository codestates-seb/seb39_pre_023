import styled from 'styled-components';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  faCakeCandles,
  faLocationDot,
} from '@fortawesome/free-solid-svg-icons';
/* eslint-disable react/prop-types */

const MyInfo = ({ nickname, location, signupDate }) => {
  let sign = new Date(String(signupDate)).getTime();
  let today = new Date().getTime();
  let dateFromSign = Math.ceil((today - sign) / 1000 / 60 / 60 / 24);
  return (
    <Container>
      <Left>
        <img
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9aJlhtrVx_GZ35lZySYo5SwodOhVxwCbIhg&usqp=CAU"
          className="profileImage"
          alt="profileImage"
        ></img>
      </Left>
      <Right>
        <div className="displayname">{nickname}</div>
        <div className="wrapper">
          <FontAwesomeIcon icon={faCakeCandles} className="icon" />
          <span className="signupdate">Member for {dateFromSign} days</span>
        </div>
        <div className="wrapper">
          <FontAwesomeIcon icon={faLocationDot} className="icon" />
          <span className="location">{location}</span>
        </div>
      </Right>
    </Container>
  );
};

export default MyInfo;

const Container = styled.div`
  display: flex;
  width: 1070px;
  height: 150px;
  margin-top: 20px;
  margin-left: 20px;
`;
const Left = styled.div`
  display: flex;
  img {
    width: 130px;
    height: 130px;
    margin-right: 20px;
    border-radius: 5px;
  }
`;
const Right = styled.div`
  display: flex;
  flex-direction: column;
  font-size: 15px;
  color: gray;
  font-weight: 400;
  margin-top: 5px;
  .displayname {
    font-size: 35px;
    font-weight: 600;
    color: black;
    margin-top: 10px;
    margin-bottom: 40px;
  }
  .wrapper {
    display: flex;
    width: 150px;
    span {
      margin-left: 10px;
    }
  }
`;
