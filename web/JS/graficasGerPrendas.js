
const grafica1 = document.getElementById('grafica1').getContext('2d');
const grafica = new Chart(grafica1, {
    type: 'polarArea',
    data: {
        labels: ['Jeans', 'Overoles', 'Chaquetas', 'Bragas', 'Shorts', 'Faldas'],
        datasets: [{
            label: '# de prendas por ategorias',
            data: [5, 0, 0, 0, 0, 0],
            backgroundColor: [
                'rgba(229, 75, 111, 0.3)',
                'rgba(13, 206, 206, 0.3)',
                'rgba(219, 229, 75, 0.4)',
                'rgba(103, 140, 243, 0.3)',
                'rgba(158, 70, 236, 0.3)',
                'rgba(236, 123, 70, 0.3)'
            ],
            borderColor: [
                'rgba(229, 75, 111, 1)',
                'rgba(13, 206, 206, 1)',
                'rgba(219, 229, 85, 1)',
                'rgba(103, 140, 243, 1)',
                'rgba(158, 70, 236, 1)',
                'rgba(236, 123, 70, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        responsive:true,
    }
});
