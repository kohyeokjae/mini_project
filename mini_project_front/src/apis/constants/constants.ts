const API_DOMAIN = import.meta.env.REACT_APP_API_DOMAIN || "http://localhost:8080";

const BASE_URL = "api/v1";

const AUTH_URL = `${API_DOMAIN}/${BASE_URL}/auth`;
const COMMON_URL = `${API_DOMAIN}/${BASE_URL}/common`;

export const KAKAO_LOGIN_URL = `${API_DOMAIN}/oauth2/authorization/kakao`
export const NAVER_LOGIN_URL = `${API_DOMAIN}/oauth2/authorization/naver`

export const USER_INFO_URL = `${COMMON_URL}/user`
export const BOOK_LIST_URL = `${COMMON_URL}/books`
export const LOGOUT_URL = `${AUTH_URL}/logout`