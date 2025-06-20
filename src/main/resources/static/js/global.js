const CustomSwal = Swal.mixin({
    background: '#0F111A',
    color: '#F8F9FA',
    confirmButtonColor: '#4FD1C5',
    cancelButtonColor: '#E74C3C',
    buttonsStyling: true
});

function swalSucesso(texto = 'Operação realizada com sucesso', url = '') {
    CustomSwal.fire({
        title: 'Sucesso!',
        text: texto,
        icon: 'success',
        confirmButtonText: 'OK'
    }).then((result) => {
        if (result.isConfirmed) {
            if (url && url.trim() !== '') {
                window.location.href = url;
            } else {
                window.location.reload();
            }
        }
    });
}

function swalErro(texto = 'Algo deu errado') {
    CustomSwal.fire({ title: 'Erro!', text: texto, icon: 'error' });
}

function swalAlerta(texto = 'Certifique-se de que está tudo correto!') {
    CustomSwal.fire({ title: 'Ops!', text: texto, icon: 'warning' });
}
