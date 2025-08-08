import { user } from "@/Interfaces/IUser";
import { Role } from "@/Utils/EnunRole";
import { useEffect, useState } from "react"



const UserService = (username:string, password:string) => {
  const [isLoaging, setIsLoading] = useState(false);
  const [isLogin, setIsLogin] = useState(false)
  const [user, setUser] =useState({});

  
  const handLogin = async() => {
    
    const response = await fetch("http://localhost:8080/auth/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ username, password }),
    });

    console.log(response);

    if(!response.ok){
      throw new Error('E-mail ou Senha invalida')
    }
    return response.json();
  }

  }

  
export default UserService;