function cadastrar() {
    let nome = $('#nomeCadastro').val();
    let matricula = $('#matriculaCadastro').val();
    let celular = $('#celularCadastro').val();
    let email = $('#emailCadastro').val();
    let password = $('#senhaCadastro').val();

    if (!nome || !matricula || !celular || !email || !password) {
        $('#errorMessage').show()
        return;
    }

    fetch('/cadastrar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-Requested-With': 'XMLHttpRequest'
        },
        body: JSON.stringify({
            nome: nome,
            matricula: matricula,
            celular: celular,
            email: email,
            password: password,
            role: "USER"
        })
    })
        .then(response => {
            if (response.ok) {
                console.log("Usuário cadastrado com sucesso!");
                window.location.href = '/login';
            } else if (response.status === 400) {
                console.log("erro: Email já cadastrado no sistema");
                alert("Email já cadastrado no sistema");
            } else {
                console.log("erro: Erro interno do servidor");
                alert("Erro interno do servidor");
            }
        })
        .catch(error => {
            console.error('Erro na requisição:', error);
            alert("Erro de conexão");
        });
}

function verificarSenha() {
    const senha = document.getElementById('senhaCadastro').value;

    const temMaiuscula = /[A-Z]/.test(senha);
    const temNumero = /\d/.test(senha);
    const temEspecial = /[^A-Za-z0-9]/.test(senha);
    const temTamanho = senha.length >= 8;

    document.getElementById('maiuscula').className = temMaiuscula ? 'text-green-600' : 'text-gray-500';
    document.getElementById('numero').className = temNumero ? 'text-green-600' : 'text-gray-500';
    document.getElementById('especial').className = temEspecial ? 'text-green-600' : 'text-gray-500';
    document.getElementById('tamanho').className = temTamanho ? 'text-green-600' : 'text-gray-500';
}