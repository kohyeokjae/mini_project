import { useNavigate } from "react-router-dom";
import styles from "./Header.module.css";
import { useLoginStore } from "@/stores/Login.store";

function Header() {
  const navigate = useNavigate();
  const { isLogin, setLogout } = useLoginStore();

  const onLogoClick = () => {
    navigate("/main");
  };

  const onMyPageButtonClick = () => {
    navigate("/myPage");
  };

  const onLoginButtonClick = () => {
    navigate("/login");
  };

  const onLogoutButtonClick = () => {
    navigate("/main");
    setLogout();
  };

  return (
    <header className={styles.header}>
      <div className={styles.logo}>
        <img
          src="public/북허브_로그_로그인창.png"
          alt="북허브 로고"
          onClick={onLogoClick}
          className={styles.logoImg}
        />
      </div>
      <div className={styles.headerInfo}>
        <div>
          <div className={styles.loginInfo}>
            {isLogin ? (
              <div style={{ display: "flex", gap: "20px" }}>
                <button onClick={onMyPageButtonClick} className={styles.btn}>
                  마이페이지
                </button>
                <button onClick={onLogoutButtonClick} className={styles.btn}>
                  로그아웃
                </button>
              </div>
            ) : (
              <button onClick={onLoginButtonClick} className={styles.btn}>
                로그인 / 회원가입
              </button>
            )}
          </div>
        </div>
      </div>
    </header>
  );
}

export default Header;
