import styled from 'styled-components';
import { Link } from 'react-router-dom';
/* eslint-disable react/prop-types */

const PostList = ({ data }) => {
  const createdAt = new Date(data.write_date).toLocaleDateString('en-us', {
    weekday: 'long',
    year: 'numeric',
    month: 'short',
    day: 'numeric',
    hour: 'numeric',
    minute: 'numeric',
  });

  return (
    <StyledPost>
      <div className="posts">
        <div className="stats-container">
          <div className="stats">
            {data.score} votes
            <div className="vote">
              <span className="vote-count">{data.answered}</span>
              <div className="count-text">{data.answers.length} answers</div>
            </div>
            <div className="vote">
              <div className="count-text">{data.view_count} views</div>
            </div>
          </div>
        </div>
        <div className="summary">
          <div>
            <Link to={`/questiondetail/${data.post_id}`}>{data.post_name}</Link>
            <div>{data.post_content}</div>
            <div className="right-bottom">
              <div className="tags">
                {data.tags.map((tag, idx) => (
                  <div key={idx} className="tagwrapper">
                    <span className="tag">{tag}</span>
                  </div>
                ))}
              </div>
              <div className="userinfo">
                <span className="username">{data.writer.nick_name}</span>
                <span className="date">asked {createdAt}</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </StyledPost>
  );
};

export default PostList;

const StyledPost = styled.div`
  @import url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');
  font-family: Roboto, sans-serif;
  .posts {
    padding: 12px 8px 12px 8px;
    width: 1070px;
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
    width: 8%;
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
    width: 90%;

    h3 {
      font-weight: 400;
      font-size: 15px;
      line-height: 1.4;
      margin-bottom: 7.5px;
    }
  }
  .right-bottom {
    display: flex;
    justify-content: space-between;
  }
  .tags {
    display: flex;
    justify-content: flex-start;
    .tagwrapper {
      cursor: pointer;
      margin-right: 5px;
      display: flex;
      padding-left: 5px;
      padding-right: 5px;
      border-radius: 3px;
      list-style: none;
      background-color: #e1ecf4;
    }
    .tagwrapper:hover {
      background-color: #d0e3f1;
    }
    .tag {
      border: none;
      padding: 3px;
      font-size: 13px;
      height: 23px;
      border-radius: 3px;
      background-color: transparent;
      white-space: nowrap;
      color: #39739d;
    }
  }
`;
