import { ILogin } from "@/Interfaces/ILogin";
import api from "../BaseUrl.service";

export const loginService = async (login: ILogin) => {
  const response = await api.post('/auth/login', login)
  return response.data
}