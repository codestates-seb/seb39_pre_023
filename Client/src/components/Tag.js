import styled from 'styled-components';
// import PropTypes from 'prop-types';

const StyledTag = styled.span`
  display: linline-block;
  margin-right: 5px;
  background-color: #e1ecf4;
  color: #9cc3db;
  padding: 7px;
  border-radius: 4px;
  width: 40px;
  font-size: 0.9rem;
`;

const Tag = () => {
  return <StyledTag>java</StyledTag>;
};

// Tag.propTypes = {
//   name: PropTypes.string.isRequired,
// };

export default Tag;
