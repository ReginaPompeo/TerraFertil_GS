import axios from "axios";

const apiNoticias = axios.create(
    {baseURL: "http://localhost:8080/LojaApp/rest/noticias"}
)

export default apiNoticias;