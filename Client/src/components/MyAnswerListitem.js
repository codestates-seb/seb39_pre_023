// import styled from 'styled-components';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCheck } from '@fortawesome/free-solid-svg-icons';
import { ItemContainer } from './MyListItem';
import styled from 'styled-components';
/* eslint-disable react/prop-types */

const MyAnswerListItem = ({ title, content, date, linkId, accepted }) => {
  return (
    <ItemContainer>
      <div className="mypostInfo">
        <InfoWrapper>
          <a href={`/${linkId}`}>
            <h4 className="myTitle">{title}</h4>
          </a>
          <span>
            {accepted ? (
              <FontAwesomeIcon className="green" icon={faCheck} />
            ) : (
              <p>not accepted</p>
            )}
          </span>
        </InfoWrapper>
        <div className="myDate">{date}</div>
      </div>
      <div className="myContent">{content}</div>
    </ItemContainer>
  );
};
export default MyAnswerListItem;
const InfoWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  p {
    margin-left: 10px;
  }
  .green {
    color: green;
  }
`;
