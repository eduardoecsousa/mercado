import { Role } from "@/Utils/EnunRole";

export interface user{
  id: number;
  email: string;
  passwoed:string;
  role: Role
}