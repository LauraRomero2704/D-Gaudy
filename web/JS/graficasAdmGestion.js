
const grafica1 = document.getElementById('grafica1').getContext('2d');
const grafica = new Chart(grafica1, {
    type: 'polarArea',
    data: {
        labels: ['Administrador', 'Gerente de Prendas', 'Gerente de Pedidos', 'Clientes'],
        datasets: [{
            label: '',
            data: [1, 1, 1, 20],
            backgroundColor: [
                'rgba(229, 75, 111, 0.3)',
                'rgba(103, 140, 243, 0.3)',
                'rgba(219, 229, 75, 0.4)',
                'rgba(13, 206, 206, 0.3)'
            ],
            borderColor: [
                'rgba(229, 75, 111, 1)',
                'rgba(103, 140, 243, 1)',
                'rgba(219, 229, 85, 1)',
                'rgba(13, 206, 206, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        responsive:true,
    }
});
