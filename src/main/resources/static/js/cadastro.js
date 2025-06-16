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
    const senha = $('#senhaCadastro').val();

    const temMaiuscula = /[A-Z]/.test(senha);
    const temNumero = /\d/.test(senha);
    const temEspecial = /[^A-Za-z0-9]/.test(senha);
    const temTamanho = senha.length >= 8;

    document.getElementById('maiuscula').className = temMaiuscula ? 'text-green-600' : 'text-gray-500';
    document.getElementById('numero').className = temNumero ? 'text-green-600' : 'text-gray-500';
    document.getElementById('especial').className = temEspecial ? 'text-green-600' : 'text-gray-500';
    document.getElementById('tamanho').className = temTamanho ? 'text-green-600' : 'text-gray-500';
}

function exibirRequisitos() {
    $('#requisitosSenha').show()
}

function toggleSenhaCadastro() {
    const input = document.getElementById('senhaCadastro');
    const icon = document.getElementById('iconeSenhaCadastro');
    const isPassword = input.type === 'password';

    input.type = isPassword ? 'text' : 'password';

    icon.innerHTML = isPassword
        ? `<path stroke-linecap="round" stroke-linejoin="round"
          d="M13.875 18.825A10.05 10.05 0 0112 19.5c-5.25 0-9-2.5-10.5-6a10.41 10.41 0 012.202-3.233m3.384-2.55A5.985 5.985 0 0112 6c5.25 0 9 2.5 10.5 6a10.455 10.455 0 01-4.216 4.724M3 3l18 18" />`
        : `<path stroke-linecap="round" stroke-linejoin="round" d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z" />
            <path stroke-linecap="round" stroke-linejoin="round" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z" />`;
}
