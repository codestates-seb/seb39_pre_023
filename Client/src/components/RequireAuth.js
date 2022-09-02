import { useSelector } from 'react-redux';
import { Navigate, useLocation } from 'react-router-dom';
/* eslint-disable react/prop-types */
const RequireAuth = ({ children, option }) => {
  const state = useSelector((state) => state.signInReducer);
  const location = useLocation();

  if (option === null) {
    return children;
  } else if (option) {
    if (state.loginState) return children;
    else {
      return <Navigate to={'/'} state={location}></Navigate>;
    }
  } else {
    if (state.loginState) {
      return <Navigate to={'/'} state={location}></Navigate>;
    } else return children;
  }
};

export default RequireAuth;
