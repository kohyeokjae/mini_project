import "./App.css";
import { Route, Routes, useLocation } from "react-router-dom";
import Login from "./views/Login";
import MainPage from "./views/MainPage";
import Header from "./layouts/header";
import LoginCallBack from "./views/LoginCallBack";
import MyPage from "./views/MyPage";

function App() {
  const location = useLocation();

  const hideHeader = location.pathname === "/login" || location.pathname === "/login/callback";

  return (
    <div
      style={{
        height: "100vh",
        display: "flex",
        flexDirection: "column",
        border: "none",
      }}
    >
      {!hideHeader && <Header />}
      <div style={{ flex: 1, display: "flex", minHeight: 0 }}>
        <main
          style={{
            flex: 1,
            padding: "30px",
          }}
        >
          <Routes>
            <Route path="/main" element={<MainPage />} />
            <Route path="/myPage" element={<MyPage />} />
            <Route path="/login" element={<Login />} />
            <Route path="/login/callback" element={<LoginCallBack />} />
          </Routes>
        </main>
      </div>
    </div>
  );
}

export default App;
