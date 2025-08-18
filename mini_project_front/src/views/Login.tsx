import { KAKAO_LOGIN_URL, NAVER_LOGIN_URL } from "@/apis/constants/constants";

function Login() {
  const kakaoLoginUrl = KAKAO_LOGIN_URL;
  const naverLoginUrl = NAVER_LOGIN_URL;

  return (
    <div>
      <h1>Login Page</h1>

      <button
        onClick={() => {
          window.location.href = kakaoLoginUrl;
        }}
      >
        Login with Kakao
      </button>

      <button
        onClick={() => {
          window.location.href = naverLoginUrl;
        }}
      >
        Login with Naver
      </button>
    </div>
  );
}

export default Login;
