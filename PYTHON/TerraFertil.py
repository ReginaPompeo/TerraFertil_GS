import oracledb
import pandas as pd

def main():
    conexao,inst_SQL,conn = conecta_BD()
    opc = 0
    while (opc!=8 and conexao==True):
        print("1-Cadastro de cliente")
        print("2-Cadastrar Tópico")
        print("3-Responder Tópico")
        print("4-Relatorio dos usuários")
        print("5-Relatorio dos tópicos")
        print("6-Relatorio das respostas")
        print("7-Pesquisar")
        print("8-Sair")

        try:
            opc = int(input("Digite a opção (1-8): "))
            if (opc == 1):
                opc_usuario = 0
                while(opc_usuario!=4):
                    print("1-Inserir cliente")
                    print("2-Alterar dados do cliente")
                    print("3-Excluir dados do cliente")
                    print("4-Voltar")
                    opc_usuario = int(input("Digite a opção (1-4): "))

                    if (opc_usuario == 1):
                        try:

                            cliente_nome = input("Digite o nome do cliente: ")
                            cliente_email = input("Digite o email do cliente: ")
                            cliente_senha = input("Digite a senha do cliente: ")
                            cliente_cpf = int(input("Digite o cpf do cliente: "))
                            cliente_cnpj = int(input("Digite o cnpj do cliente: "))
                            print("Exemplo: 10-MAR-1996")
                            data_nascimento = input("Digite a data de nascimento do cliente (DD-MON-YYYY): ")
                            cliente_contato = int(input("Digite o número de contato do cliente: "))
                            cliente_cep = int(input("Digite o cep do cliente: "))

                        except ValueError:
                            print("Digite valores númericos")
                        else:
                            str_insert = f"""INSERT INTO cliente (cliente_nome,cliente_email,cliente_senha,cliente_cpf,cliente_cnpj,data_nascimento,cliente_contato,cliente_cep) VALUES ('{cliente_nome}','{cliente_email}','{cliente_senha}',{cliente_cpf},{cliente_cnpj},'{data_nascimento}',{cliente_contato},{cliente_cep})"""
                            insert_tabela(inst_SQL, conn, str_insert)

                    elif (opc_usuario == 2):
                        try:
                            lista_dados = []

                            cliente_id = int(input("Digite o ID da cliente a ser alterado: "))

                            consulta = f"""SELECT * FROM cliente WHERE cliente_id = {cliente_id}"""

                            inst_SQL.execute(consulta)
                            dados = inst_SQL.fetchall()

                            for dado in dados:
                                lista_dados.append(dado)

                            if (len(lista_dados) == 0):
                                print("Id não encontrado")
                            else:
                                try:
                                    novo_cliente_nome = input("Digite o novo nome do cliente: ")
                                    novo_cliente_email = input("Digite o novo email do cliente: ")
                                    novo_cliente_senha = input("Digite a novo senha do cliente: ")
                                    novo_cliente_contato = int(input("Digite o novo número de contato do cliente: "))
                                    novo_cliente_cep = int(input("Digite o novo cep do cliente: "))

                                except ValueError:
                                    print("Digite valores númericos")
                                else:
                                    str_update = f"""UPDATE cliente SET cliente_nome='{novo_cliente_nome}',cliente_email='{novo_cliente_email}',cliente_senha='{novo_cliente_senha}',cliente_contato={novo_cliente_contato},cliente_cep={novo_cliente_cep} WHERE cliente_id={cliente_id}"""
                                    update_tabela(inst_SQL, conn, str_update)
                        except ValueError:
                            print("Digite valor númerico")

                    elif (opc_usuario == 3):
                        try:
                            lista_dados = []

                            cliente_id = int(input("Digite o ID da cliente a ser excluido: "))

                            consulta = f"""SELECT * FROM cliente WHERE cliente_id = {cliente_id}"""

                            inst_SQL.execute(consulta)
                            dados = inst_SQL.fetchall()

                            for dado in dados:
                                lista_dados.append(dado)

                            if (len(lista_dados) == 0):
                                print("O ID digitado não existe na tabela")
                            else:
                                str_delete = f"""DELETE FROM cliente WHERE cliente_id={cliente_id}"""
                                delete_tabela(inst_SQL, conn, str_delete)
                        except ValueError:
                            print("Digite valor númerico")

            elif (opc == 2):
                opc_pergunta = 0
                while (opc_pergunta != 4):
                    print("1-Inserir tópico")
                    print("2-Alterar dados do tópico")
                    print("3-Excluir dados do tópico")
                    print("4-Voltar")
                    opc_pergunta = int(input("Digite a opção (1-4): "))

                    if (opc_pergunta == 1):
                        try:
                            pergunta_titulo = input("Digite o titulo da pergunta do cliente: ")
                            pergunta_texto = input("Digite a pergunta do cliente: ")
                            data_postagem = input("Digite a data da postagem do cliente: ")

                            str_consulta = 'SELECT * FROM cliente'
                            str_colunas = f"""SELECT column_name FROM all_tab_cols WHERE table_name = 'CLIENTE' order by column_id"""

                            inst_SQL.execute(str_colunas)
                            dados = inst_SQL.fetchall()
                            colunas = []
                            for i in range(len(dados)):
                                colunas.append(dados[i][0].split("_")[1])

                            consulta_tabela(inst_SQL, str_consulta, colunas)

                            lista_dados = []

                            cliente_id = int(input("Digite o ID do cliente que fez a pergunta: "))

                            consulta = f"""SELECT * FROM cliente WHERE cliente_id = {cliente_id}"""

                            inst_SQL.execute(consulta)
                            dados = inst_SQL.fetchall()


                            for dado in dados:
                                lista_dados.append(dado)

                            if (len(lista_dados) == 0):
                                print("ID não encontrado")

                        except ValueError:
                            print("Digite valores númericos")
                        else:
                            str_insert = f"""insert into topico (pergunta_titulo, pergunta_texto, data_postagem, topico_clienteID) values ('{pergunta_titulo}','{pergunta_texto}','{data_postagem}',{cliente_id})"""
                            insert_tabela(inst_SQL, conn, str_insert)

                    elif (opc_pergunta == 2):
                        try:
                            lista_dados = []

                            topico_id = int(input("Digite o ID do tópico a ser alterado: "))

                            consulta = f"""SELECT * FROM topico WHERE topico_id = {topico_id}"""

                            inst_SQL.execute(consulta)
                            dados = inst_SQL.fetchall()

                            for dado in dados:
                                lista_dados.append(dado)

                            if (len(lista_dados) == 0):
                                print("Id não encontrado")
                            else:
                                try:
                                    novo_pergunta_titulo = input("Digite o titulo da pergunta do cliente: ")
                                    novo_pergunta_texto = input("Digite a pergunta do cliente: ")

                                except ValueError:
                                    print("Digite valores númericos")
                                else:
                                    str_update = f"""UPDATE topico SET pergunta_titulo='{novo_pergunta_titulo}',pergunta_texto='{novo_pergunta_texto}' WHERE topico_id={topico_id}"""
                                    update_tabela(inst_SQL, conn, str_update)
                        except ValueError:
                            print("Digite valor númerico")

                    elif (opc_pergunta == 3):
                        try:
                            lista_dados = []

                            topico_id = int(input("Digite o ID da tópico a ser excluido: "))

                            consulta = f"""SELECT * FROM topico WHERE topico_id = {topico_id}"""

                            inst_SQL.execute(consulta)
                            dados = inst_SQL.fetchall()

                            for dado in dados:
                                lista_dados.append(dado)

                            if (len(lista_dados) == 0):
                                print("O ID digitado não existe na tabela")
                            else:
                                str_delete = f"""DELETE FROM topico WHERE topico_id={topico_id}"""
                                delete_tabela(inst_SQL, conn, str_delete)
                        except ValueError:
                            print("Digite valor númerico")
            elif (opc == 3):
                opc_resposta = 0
                while (opc_resposta != 4):
                    print("1-Inserir resposta")
                    print("2-Alterar dados da resposta")
                    print("3-Excluir dados da resposta")
                    print("4-Voltar")
                    opc_resposta = int(input("Digite a opção (1-4): "))

                    if (opc_resposta == 1):
                        try:
                            # Primeira consulta
                            str_consulta = 'SELECT * FROM cliente'
                            str_colunas = f"""SELECT column_name FROM all_tab_cols WHERE table_name = 'CLIENTE' order by column_id"""

                            inst_SQL.execute(str_colunas)
                            dados = inst_SQL.fetchall()
                            colunas = []

                            for i in range(len(dados)):
                                colunas.append(dados[i][0].split("_")[1])

                            consulta_tabela(inst_SQL, str_consulta, colunas)

                            cliente_id = int(input("Digite o ID do cliente que respondera o tópico: "))

                            # Segunda consulta
                            str_consulta2 = 'SELECT * FROM topico'
                            str_colunas2 = f"""SELECT column_name FROM all_tab_cols WHERE table_name = 'TOPICO' order by column_id"""

                            inst_SQL.execute(str_colunas2)
                            dados2 = inst_SQL.fetchall()
                            colunas2 = []

                            for i in range(len(dados2)):
                                colunas2.append(dados2[i][0].split("_")[1])

                            consulta_tabela(inst_SQL, str_consulta2, colunas2)

                            topico_id = int(input("Digite o ID do tópico que o cliente respondera: "))
                            resposta_texto = input("Digite a resposta do cliente: ")
                            data_postagem = input("Digite a data da postagem do cliente: ")

                            lista_dados = []

                            consulta = f"""SELECT * FROM cliente WHERE cliente_id = {cliente_id}"""

                            inst_SQL.execute(consulta)
                            dados = inst_SQL.fetchall()

                            for dado in dados:
                                lista_dados.append(dado)

                            if (len(lista_dados) == 0):
                                print("ID não encontrado")

                            lista_dados2 = []

                            consulta = f"""SELECT * FROM topico WHERE topico_id = {topico_id}"""

                            inst_SQL.execute(consulta)
                            dados = inst_SQL.fetchall()


                            for dado in dados:
                                lista_dados2.append(dado)

                            if (len(lista_dados2) == 0):
                                print("ID não encontrado")

                        except ValueError:
                            print("Digite valores númericos")
                        else:
                            str_insert = f"""INSERT INTO resposta (resposta_texto, data_postagem,resposta_clienteID, resposta_topicoID) VALUES ('{resposta_texto}','{data_postagem}',{cliente_id}, {topico_id})"""
                            insert_tabela(inst_SQL, conn, str_insert)



            elif (opc == 4):
                str_consulta = 'SELECT * FROM cliente'
                str_colunas = f"""SELECT column_name FROM all_tab_cols WHERE table_name = 'CLIENTE' order by column_id"""

                inst_SQL.execute(str_colunas)
                dados = inst_SQL.fetchall()

                colunas = []
                for i in range(len(dados)):
                    colunas.append(dados[i][0].split("_")[1])

                consulta_tabela(inst_SQL, str_consulta, colunas)
            elif (opc == 5):
                str_consulta = 'SELECT * FROM topico'
                str_colunas = f"""SELECT column_name FROM all_tab_cols WHERE table_name = 'TOPICO' order by column_id"""

                inst_SQL.execute(str_colunas)
                dados = inst_SQL.fetchall()

                colunas = []
                for i in range(len(dados)):
                    colunas.append(dados[i][0].split("_")[1])

                consulta_tabela(inst_SQL, str_consulta, colunas)

            elif (opc == 6):
                str_consulta = 'SELECT * FROM resposta'
                str_colunas = f"""SELECT column_name FROM all_tab_cols WHERE table_name = 'RESPOSTA' order by column_id"""

                inst_SQL.execute(str_colunas)
                dados = inst_SQL.fetchall()

                colunas = []
                for i in range(len(dados)):
                    colunas.append(dados[i][0].split("_")[1])

                consulta_tabela(inst_SQL, str_consulta, colunas)


            elif (opc == 7):
                opc_usuario = 0
                while (opc_usuario != 4):
                    print("1-Pesquisar cliente")
                    print("2-Pesquisar tópico")
                    print("3-Pesquisar resposta")
                    print("4-Sair")

                    opc_usuario = int(input("Digite a opção: "))

                    if (opc_usuario == 1):
                        Pesquisar = int(input("Digite o ID do cliente que deseja visualizar: "))

                        str_consulta = f"""SELECT * FROM cliente where cliente_id = {Pesquisar}"""
                        str_colunas = f"""SELECT column_name FROM all_tab_cols WHERE table_name = 'CLIENTE' order by column_id"""

                        inst_SQL.execute(str_colunas)
                        dados = inst_SQL.fetchall()

                        colunas = []
                        for i in range(len(dados)):
                            colunas.append(dados[i][0].split("_")[1])

                        consulta_tabela(inst_SQL, str_consulta, colunas)

                    elif (opc_usuario == 2):
                        Pesquisar = int(input("Digite o ID do tópico que deseja visualizar: "))

                        str_consulta = f"""SELECT * FROM topico where topico_id = {Pesquisar}"""
                        str_colunas = f"""SELECT column_name FROM all_tab_cols WHERE table_name = 'TOPICO' order by column_id"""

                        inst_SQL.execute(str_colunas)
                        dados = inst_SQL.fetchall()

                        colunas = []
                        for i in range(len(dados)):
                            colunas.append(dados[i][0].split("_")[1])

                        consulta_tabela(inst_SQL, str_consulta, colunas)

                    elif (opc_usuario == 3):
                        Pesquisar = int(input("Digite o ID da resposta que deseja visualizar: "))

                        str_consulta = f"""SELECT * FROM resposta where resposta_id = {Pesquisar}"""
                        str_colunas = f"""SELECT column_name FROM all_tab_cols WHERE table_name = 'RESPOSTA' order by column_id"""

                        inst_SQL.execute(str_colunas)
                        dados = inst_SQL.fetchall()

                        colunas = []
                        for i in range(len(dados)):
                            colunas.append(dados[i][0].split("_")[1])

                        consulta_tabela(inst_SQL, str_consulta, colunas)

        except ValueError:
            print("Digite valor númerico")


def conecta_BD():

    try:
        dnStr = oracledb.makedsn("oracle.fiap.com.br","1521","ORCL")
        conn = oracledb.connect(user='rm97305',password='040404',dsn=dnStr)
        inst_SQL = conn.cursor()

    except Exception as e:
        print("Erro: ", e)
        conexao = False
        inst_SQL = ""
        conn = ""
    else:
        conexao = True

    return(conexao,inst_SQL,conn)


def insert_tabela(inst_SQL,conn,str_insert):
    try:
        inst_SQL.execute(str_insert)
        conn.commit()

    except:
        print("Erro de transacao com o BD")
    else:
        print("Dados gravados com sucesso")

def consulta_tabela(inst_SQL,str_consulta,colunas):
    lista = []

    inst_SQL.execute(str_consulta)
    dados = inst_SQL.fetchall()

    for registro in dados:
        lista.append(registro)

    lista = sorted(lista)

    base_df = pd.DataFrame.from_records(lista, columns=colunas, index=colunas[0])

    if (base_df.empty):
        print("Não ha registros cadastrados")
    else:
        print(base_df)
        print("\n")


def update_tabela(inst_SQL,conn,str_update):
        try:
            inst_SQL.execute(str_update)
            conn.commit()
        except:
            print("Erro de transacao com o BD")
        else:
            print("Dados alterados com sucesso")


def delete_tabela(inst_SQL, conn, str_delete):
    try:
        inst_SQL.execute(str_delete)
        conn.commit()
    except:
        print("Erro de transacao com o BD")
    else:
        print("Dados excluidos com sucesso")


if (__name__ == "__main__"):
    main()