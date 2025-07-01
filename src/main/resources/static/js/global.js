const CustomSwal = Swal.mixin({
    background: '#0F111A',
    color: '#F8F9FA',
    confirmButtonColor: '#3D5A80',
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

function swalConfirmarAcao(texto = 'Tem certeza de que deseja continuar?') {
   return CustomSwal.fire({title: 'Atenção!', text: texto, icon: 'warning', showCancelButton: true, confirmButtonText: 'Sim'})
}

function swalErroInterno() {
    CustomSwal.fire({ title: 'Erro!', text: 'Erro interno no servidor. Tente novamente mais tarde ou contate o suporte.', icon: 'error' });
}

function swalLoading(texto = 'Estamos processando sua requisição') {
    CustomSwal.fire({
        title: 'Aguarde um instante...',
        text: texto,
        allowOutsideClick: false,
        allowEscapeKey: false,
        showConfirmButton: false,
        didOpen: () => {
            CustomSwal.showLoading();
        }
    });
}
