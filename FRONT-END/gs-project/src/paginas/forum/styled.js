import styled from "styled-components";

export const AreaForum = styled.div`
    .container-flex{
        display: flex;
        flex-direction: column;
        align-items: center;
        border:1px solid black;
    }
    .container-1{
        height: 200px;
        width: 900px;
        border: 1px solid #A9A9A9;
        margin-top: 20px;
        .texto{
            margin-top: 40px;
            margin-left: 30px;
        }
        .Button{
            margin-left: 30px;
            margin-top: 30px;
        }
    }
    .container-2{
        height: 150px;
        width: 900px;
        border: 1px solid #A9A9A9;
        
    }
    .pergunta{
        margin-top: 60px;
        margin-left: 20px;
        cursor: pointer;
    }
    .date{
        text-align: end;
        margin-top: 30px;
        margin-right: 10px;
    }
`