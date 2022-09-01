import styled from 'styled-components';

const ArrowUp = styled.div`
  width: 0;
  height: 0;
  border-left: 20px solid transparent;
  border-right: 20px solid transparent;
  border-bottom: 20px solid #bbb;
  padding-top: 15px;
`;

const ArrowDown = styled.div`
  width: 0;
  height: 0;
  border-left: 20px solid transparent;
  border-right: 20px solid transparent;
  border-top: 20px solid #bbb;
  padding-top: 0;
  margin-top: 0;
`;

const ArrowButton = styled.button`
  border: 0;
  background: none;
  font-size: 2rem;
  color: #888;
  cursor: pointer;
  text-align: center;
  padding-left: 20px;
  padding-right: 0px;
  margin-right: 0;
`;

const Total = styled.div`
  text-align: center;
  width: 50px;
  padding-left: 30px;
  color: #888;
  font-size: 2rem;
  padding-bottom: 4px;
`;

const VotingButton = () => {
  return (
    <div>
      <ArrowButton>
        <ArrowUp></ArrowUp>
      </ArrowButton>
      <Total>0</Total>
      <ArrowButton>
        <ArrowDown></ArrowDown>
      </ArrowButton>
    </div>
  );
};

export default VotingButton;
