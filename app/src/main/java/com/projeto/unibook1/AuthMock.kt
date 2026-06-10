package com.projeto.unibook1

/**
 * Utilitário para facilitar o acesso às telas durante o desenvolvimento.
 * Use estas credenciais para entrar sem precisar configurar o Firebase.
 */
object AuthMock {
    // Credenciais para Aluno (Usuario Comum)
    const val USER_MATRICULA = "123"
    const val USER_SENHA = "123"

    // Credenciais para Administrador
    const val ADMIN_MATRICULA = "123"
    const val ADMIN_SENHA = "admin"

    /**
     * Verifica se as credenciais correspondem ao login "Dummy" de usuário
     */
    fun isUserDummy(matricula: String, senha: String): Boolean {
        return matricula == USER_MATRICULA && senha == USER_SENHA
    }

    /**
     * Verifica se as credenciais correspondem ao login "Dummy" de administrador
     */
    fun isAdminDummy(matricula: String, senha: String): Boolean {
        return matricula == ADMIN_MATRICULA && senha == ADMIN_SENHA
    }
}
