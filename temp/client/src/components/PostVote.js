import styled from 'styled-components';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCaretUp, faCaretDown } from '@fortawesome/free-solid-svg-icons';
/* eslint-disable react/prop-types */
const Container = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 10px;

  margin: 10px;
  .arrow {
    font-size: 3rem;
    color: #babfc4;
    cursor: pointer;
  }
  span {
    color: #abb0b5;
    font-size: 20px;
  }
`;

const PostVote = ({ votes, onIncreaseVote, onDecreaseVote }) => {
  const onPlus = () => {
    onIncreaseVote();
  };
  const onMinus = () => {
    onDecreaseVote();
  };
  return (
    <Container>
      <FontAwesomeIcon icon={faCaretUp} onClick={onPlus} className="arrow" />
      <span>{votes}</span>
      <FontAwesomeIcon icon={faCaretDown} onClick={onMinus} className="arrow" />
    </Container>
  );
};
export default PostVote;
