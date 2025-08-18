import type ResponseDto from "@/dtos/Response.dto";
import axios, { AxiosError, type AxiosResponse } from "axios";

export const axiosInstance = axios.create({
  baseURL: import.meta.env.REACT_APP_API_DOMIN || "http://localhost:8080",
  withCredentials: true,
  timeout: 8000,
});

export const responseSuccessHandler = <T = any>(
  response: AxiosResponse<ResponseDto<T>>
) => {
  return response.data;
};

export const responseErrorHandler = (error: AxiosError<ResponseDto>) => {
  if (!error.response)
    return { code: "NETWORK_ERROR", message: "네트워크 오류", data: null };
  return error.response.data;
};

export const bearerAuthorization = (accessToken: string) => ({
  headers: { Authorization: `Bearer ${accessToken}` },
});
