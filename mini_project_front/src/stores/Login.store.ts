import { logoutResquest } from "@/apis/auth/Auth";
import { create } from "zustand";
import { createJSONStorage, persist } from "zustand/middleware";

interface LoginStore {
  isLogin: boolean;
  setLogin: () => void;
  setLogout: () => void;
}

export const useLoginStore = create<LoginStore>()(
  persist(
    (set) => ({
      isLogin: false,
      setLogin: () => set({ isLogin: true }),
      setLogout: async () => {
        try {
          await logoutResquest();
        } catch (e) {
          console.error("로그아웃 실패", e);
        } finally {
          set({ isLogin: false });
          alert("로그아웃 되었습니다.");
          window.location.href = "/main";
        }
      },
    }),
    {
      name: "login-storage",
      storage: createJSONStorage(() => localStorage),
    }
  )
);
