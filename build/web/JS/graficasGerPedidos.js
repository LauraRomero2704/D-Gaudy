
const grafica1 = document.getElementById('grafica1').getContext('2d');
const grafica = new Chart(grafica1, {
    type: 'polarArea',
    data: {
        labels: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10'],
        datasets: [{
            label: '',
            data: [495.000, 801.000, 792.000, 450.000, 1.008000, 200.000, 918.000, 1.116000, 900.000, 882.000],
            backgroundColor: [
                'rgba(229, 75, 111, 0.3)',
                'rgba(13, 206, 206, 0.3)',
                'rgba(219, 229, 75, 0.4)',
                'rgba(103, 140, 243, 0.3)',
                'rgba(158, 70, 236, 0.3)',
                'rgba(236, 123, 70, 0.3)',
                'rgba(203, 75, 229, 0.3)',
                'rgba(23, 13, 206, 0.3)',
                'rgba(229, 157, 75, 0.3)',
                'rgba(103, 243, 105, 0.3)'
            ],
            borderColor: [
                'rgba(229, 75, 111, 1)',
                'rgba(13, 206, 206, 1)',
                'rgba(219, 229, 85, 1)',
                'rgba(103, 140, 243, 1)',
                'rgba(158, 70, 236, 1)',
                'rgba(236, 123, 70, 1)',
                'rgba(203, 75, 229, 1)',
                'rgba(23, 13, 206, 1)',
                'rgba(229, 157, 75, 1)',
                'rgba(103, 243, 105, 0.3)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        responsive:true,
    }
});