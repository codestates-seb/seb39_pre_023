const signInReducer = (state = { loginState: false }, action) => {
  switch (action.type) {
    case 'CHECK_LOGIN':
      return { ...state, loginState: action.payload.msg };
    case 'USER_DATA':
      return { ...state, data: action.payload.data };
    case 'SIGN_OUT':
      return { ...state, loginState: action.payload.msg };
    default:
      return state;
  }
};
export default signInReducer;
