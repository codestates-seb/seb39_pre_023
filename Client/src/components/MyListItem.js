import styled from 'styled-components';
/* eslint-disable react/prop-types */

const MyListItem = ({ title, content, date, postId }) => {
  return (
    <ItemContainer>
      <div className="mypostInfo">
        <a href={`/${postId}`}>
          <h4 className="myTitle">{title}</h4>
        </a>
        <div className="myDate">{date}</div>
      </div>
      <div className="myContent">{content}</div>
    </ItemContainer>
  );
};
export default MyListItem;

const ItemContainer = styled.li`
  display: flex;
  flex-direction: column;
  list-style: none;
  margin-bottom: 15px;
  margin-right: 20px;
  .mypostInfo {
    display: flex;
    width: 100%;
    min-height: 25px;
    justify-content: space-between;
  }
  .myTitle {
    font-size: 18px;
  }
  a {
    text-decoration: none;
    color: #333536;
  }
  .myDate {
    color: #808080;
  }
`;
