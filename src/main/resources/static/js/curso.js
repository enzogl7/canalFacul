function criarCurso() {
    const nome = $('#nomeCurso').val();
    const modalidade = $('#modalidade').val();
    const turma = $('#turma').val();
    const descricao = $('#descricao').val();

    if (!nome || !modalidade || !turma) {
        swalAlerta('Preencha todos os campos obrigatórios.');
        return;
    }

    fetch('/admin/criarcurso', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-Requested-With': 'XMLHttpRequest'
        },
        body: JSON.stringify({ nome, modalidade, turma, descricao }),
        credentials: 'include'
    })
        .then(async response => {
            const mensagem = await response.text();
            if (response.ok) {
                swalSucesso('Curso criado com sucesso!');
            } else {
                swalErro(mensagem || 'Erro ao criar curso.');
            }
        })
        .catch(error => {
            console.error('Erro na requisição:', error);
            swalErro('Erro de rede. Tente novamente mais tarde.');
        });
}
