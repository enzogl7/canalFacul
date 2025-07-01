function criarCurso() {
    const nome = $('#nomeCurso').val();
    const modalidade = $('#modalidade').val();
    const turma = $('#turma').val();
    const descricao = $('#descricao').val();

    if (!nome || !modalidade || !turma) {
        swalAlerta('Preencha todos os campos obrigatórios.');
        return;
    }

    fetch('/admin/novocurso', {
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
                swalSucesso('Curso criado com sucesso!', '/admin/cursos');
            } else {
                swalErro(mensagem || 'Erro ao criar curso.');
            }
        })
        .catch(error => {
            console.error('Erro na requisição:', error);
            swalErroInterno()
        });
}

function confirmacaoExcluirCurso(dataButton) {
    swalConfirmarAcao('Tem certeza de que deseja apagar este curso?')
        .then((resultado) => {
            if (resultado.isConfirmed) {
                excluirCurso(dataButton.dataset.id)
            }
        });
}

function excluirCurso(id) {
    swalLoading('Excluindo curso')

    fetch(`/admin/excluircurso?id=${encodeURIComponent(id)}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'X-Requested-With': 'XMLHttpRequest'
        },
        credentials: 'include'
    })
        .then(async response => {
            CustomSwal.close();
            const data = await response.json();
            let mensagem = data.message || 'Erro desconhecido.';
            if (response.ok) {
                swalSucesso('Curso excluído com sucesso!', '/admin/cursos');
            } else {
                swalErro(mensagem || 'Erro ao criar curso.');
            }
        })
        .catch(error => {
            console.error('Erro na requisição:', error);
            swalErroInterno()
        });
}
