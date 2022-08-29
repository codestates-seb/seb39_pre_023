import styled from 'styled-components';
import MySettings from './MySettings';
import MyProfile from './MyProfile';
import { useState } from 'react';
/* eslint-disable react/prop-types */
const Container = styled.div`
  display: flex;
  flex-direction: column;
  margin-left: 20px;
`;
const Top = styled.div`
  display: flex;
  button {
    cursor: pointer;
    border: none;
    padding: 5px;
    font-size: 14px;
    white-space: nowrap;
    border-radius: 30px;
    width: 68px;
    height: 30px;
    font-weight: 400;
  }
  button:first-child {
    margin-right: 10px;
  }
  .deActive {
    background-color: white;
    color: black;
  }
  .deActive:hover {
    background-color: #cfd3d6;
  }
  .active {
    background-color: #f48226;
    color: white;
  }
  .active:hover {
    background-color: #b65607;
  }
`;
const Bottom = styled.div`
  display: flex;
`;
const MyContent = () => {
  const [isProfile, setIsProfile] = useState(true);
  return (
    <Container>
      <Top>
        <button
          onClick={() => setIsProfile(true)}
          className={isProfile ? 'active' : 'deActive'}
        >
          Profile
        </button>
        <button
          onClick={() => setIsProfile(false)}
          className={isProfile ? 'deActive' : 'active'}
        >
          Settings
        </button>
      </Top>
      <Bottom>
        {isProfile ? <MyProfile /> : <MySettings setIsProfile={setIsProfile} />}
      </Bottom>
    </Container>
  );
};

export default MyContent;
