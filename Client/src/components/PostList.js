import styled from 'styled-components';
import { Link } from 'react-router-dom';
/* eslint-disable react/prop-types */

const StyledPost = styled.div`
  @import url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');
  font-family: Roboto, sans-serif;
  .posts {
    padding: 12px 8px 12px 8px;
    width: 100%;
    box-sizing: border-box;
    display: flex;
    border-bottom: 1px solid #4a4e51;
  }

  .stats {
    display: flex;
    flex-direction: column;
    flex-shrink: 0;
    flex-wrap: wrap;
    align-items: flex-end;
  }

  .stats-container {
    width: 58px;
    color: #6a737c;
    margin-left: 20px;
    font-size: 11px;
  }
  .vote {
    padding: 0;
    margin-bottom: 8px;
    text-align: center;
    display: flex;

    .vote-count {
      font-size: 14px;
      margin-right: 2px;
    }

    .count-text {
      font-size: 12px;
    }
  }

  .answer {
    border: 2px solid #63b47c;
    background-color: #63b47c;
    color: white;
    border-radius: 3px;
    padding: 4px;

    .vote-count {
      color: white;
      font-size: 12px;
      padding: 1px;
    }
    .count-text {
      color: white;
      font-size: 12px;
      padding: 1px;
    }
  }

  .vote {
    padding: 0;
    margin-bottom: 8px;
    text-align: center;
    display: flex;

    .vote-count {
      font-size: 12px;
      margin-right: 2px;
    }

    .count-text {
      font-size: 12px;
    }

    .views {
      .count-text {
        font-size: 12px;
        color: #ffa600;
      }
    }
  }

  .summary {
    margin-left: 30px;
    width: 600px;

    h3 {
      font-weight: 400;
      font-size: 15px;
      line-height: 1.4;
      margin-bottom: 7.5px;
    }
  }
`;

const PostList = ({ lists }) => {
  console.log({ lists });
  return (
    <StyledPost>
      {lists.map((el) => (
        <div className="posts" key={el.post_id}>
          <div className="stats-container">
            <div className="stats">
              1 votes
              <div className="vote">
                <span className="vote-count">{el.answered}</span>
                <div className="count-text">answers</div>
              </div>
              <div className="vote">
                <div className="count-text">{el.view_count} views</div>
              </div>
            </div>
          </div>
          <div className="summary">
            <div>
              <Link to="/questiondetail">{el.post_name}</Link>
              <div>{el.post_content}</div>
              <div>{el.write_date}</div>
            </div>
          </div>
        </div>
      ))}
    </StyledPost>
  );
};

export default PostList;
