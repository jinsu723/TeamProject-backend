const lineChart = document.getElementById("line-chart");
const tierUserChart = document.getElementById("user-tier-chart");
const banUserChart = document.getElementById("user-ban-chart");
const postCategoryChart = document.getElementById("post-categoty-chart");


//게시글 날짜
// let postsDataTimeStamp = [35, 20, 85, 15, 58, 53, 25];

//게시글 수(날짜에 맞춰서)
// let postsDataArray = ["2025-01-09", "2025-01-10", "2025-01-11", "2025-01-12", "2025-01-13", "2025-01-14", "2025-01-15"];
const totalDuration = 500;

let postsDataTimeStamp = [35, 20, 85, 15, 58, 53, 25];
let postsDataArray = ["2025-01-09", "2025-01-10", "2025-01-11", "2025-01-12", "2025-01-13", "2025-01-14", "2025-01-15"];
// let prev = 100;
// let prev2 = 80;
// for (let i = 0; i < 1000; i++) {
//   prev += 5 - Math.random() * 10;
//   data.push({x: i, y: prev});
//   prev2 += 5 - Math.random() * 10;
//   postsDataArray.push({x: i, y: prev2});
// }

// const delayBetweenPoints = totalDuration / postsDataTimeStamp.length;
// const previousY = (ctx) => ctx.index === 0 ? ctx.chart.scales.y.getPixelForValue(100) : ctx.chart.getDatasetMeta(ctx.datasetIndex).data[ctx.index - 1].getProps(['y'], true).y;
// const animation = {
//   x: {
//     type: 'number',
//     easing: 'linear',
//     duration: delayBetweenPoints,
//     from: NaN, // the point is initially skipped
//     delay(ctx) {
//       if (ctx.type !== 'data' || ctx.xStarted) {
//         return 0;
//       }
//       ctx.xStarted = true;
//       return ctx.index * delayBetweenPoints;
//     }
//   },
//   y: {
//     type: 'number',
//     easing: 'linear',
//     duration: delayBetweenPoints,
//     from: previousY,
//     delay(ctx) {
//       if (ctx.type !== 'data' || ctx.yStarted) {
//         return 0;
//       }
//       ctx.yStarted = true;
//       return ctx.index * delayBetweenPoints;
//     }
//   }
// };


const mylineChart = new Chart(lineChart, {
    type: 'line',
    data: {
        labels: postsDataArray,
        datasets: [{
            data: postsDataTimeStamp, //임시데이터 추후 배열로 값 가져오기
            label: "일별 게시글 추이",
            lineTension: 0.0,
            backgroundColor: "rgb(255, 255, 255)",
            borderColor: "rgb(71, 187, 255)",
            pointRadius: 3,
            pointBackgroundColor: "rgb(0, 64, 255)",
            pointBorderColor: "rgb(0, 64, 255)",
            pointHoverRadius: 3,
            pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
            pointHoverBorderColor: "rgba(78, 115, 223, 1)",
            pointHitRadius: 1,
            pointBorderWidth: 1,
            fill: false
        }]
    },
    options: {
        responsive: false,
        maintainAspectRatio: true,
        layout: {
            padding: {
                left: 10,
                right: 25,
                top: 25,
                bottom: 0
            }
        },
        scales: {
            x: {
                type: 'category',
                time: {
                    unit: 'day',
                    tooltipFormat: 'll',
                },
                grid: {
                    color: "rgba(221, 221, 221, 0.5)",
                    zeroLineColor: "rgb(156, 156, 156)",
                    drawBorder: true,
                    borderDash: [10],
                    zeroLineBorderDash: [10]
                },
                ticks: {
                    maxTicksLimit: 12
                }
            },
            y: {
                ticks: {
                    maxTicksLimit: 5,
                    padding: 10,
                    min: 1,
                    max: 100
                },
                grid: {
                    color: "rgb(145, 145, 145)",
                    zeroLineColor: "rgb(255, 255, 255)",
                    drawBorder: true,
                    borderDash: [0],
                    zeroLineBorderDash: [1]
                }
            }
        },
        // animation,
        // interaction: {
        //     intersect: false
        // },
        plugins: {
            legend: {
                display: false
            },
            tooltip: {
                backgroundColor: "rgb(0, 0, 0)",
                color: "rgb(255, 255, 255)",
                bodyFontColor: "#858796",
                titleMarginBottom: 10,
                titleFontColor: '#6e707e',
                titleFontSize: 14,
                borderColor: '#dddfeb',
                borderWidth: 1,
                xPadding: 15,
                yPadding: 15,
                displayColors: false,
                intersect: false,
                mode: 'index',
                caretPadding: 10,
                callbacks: {
                    // tooltip에 표시될 값을 커스터마이즈
                    label: function (tooltipItem) {
                        const posts = tooltipItem.raw;
                        return `${posts}개 게시글`;
                    }
                }
            }
        }
    }
});

let userTierValue = [85, 15, 58, 53, 25, 31, 95, 33, 35, 57];
const tierChart = new Chart(tierUserChart, {
    type: 'doughnut',
    data: {
        labels: ["언랭", "브론즈", "실버", "골드", "벌레티넘", "에메랄드", "다이아몬드", "마스터", "그랜드마스터", "챌린저"],
        datasets: [{
            backgroundColor: ["#483A39", "#5B3E3A", "#43545E", "#BDA473", "#4488A2",
                "#35BE70", "#70A2EC", "#BC6CEE", "#C5363A", "#55DDF1"], // 각 티어별 색상 지정
            data: userTierValue // 실제 데이터 삽입
        }]
    },
    options: {
        responsive: false,
        // 레전드 숨기기
        plugins: {
            legend: {
                display: false
            },
            tooltip: {
                backgroundColor: "rgb(0, 0, 0)",
                titleFont: { size: 15 },
                bodyFont: { size: 20 },
                titleColor: '#FFFFFF',
                bodyColor: "rgb(255, 255, 255)",
                borderWidth: 3,
                padding: 15,
                displayColors: true,
                callbacks: {
                    label: function (tooltipItem) {
                        const dataset = tooltipItem.dataset;
                        const index = tooltipItem.dataIndex;
                        const value = dataset.data[index];
                        return `${value}명`;
                    }
                }
            }
        },
        // 레이블 숨기기
        elements: {
            arc: {
                borderWidth: 1,
                borderColor: '#FFFFFF'
            }
        }
    }
});







let userBanValue = [372, 115]; //전체 회원이 487명이라고 가정
const banChart = new Chart(banUserChart, {
    type: 'doughnut',
    data: {
        labels: ["회원", "밴 유저",],
        datasets: [{
            backgroundColor: ["rgb(141, 141, 141)", "rgb(255, 0, 0)"], // 각 티어별 색상 지정
            data: userBanValue // 실제 데이터 삽입
        }]
    },
    options: {
        responsive: false,
        // 레전드 숨기기
        plugins: {
            legend: {
                display: false
            },
            tooltip: {
                backgroundColor: "rgb(0, 0, 0)",
                titleFont: { size: 15 },
                bodyFont: { size: 20 },
                titleColor: '#FFFFFF',
                bodyColor: "rgb(255, 255, 255)",
                borderWidth: 3,
                padding: 15,
                displayColors: true,
                callbacks: {
                    label: function (tooltipItem) {
                        const dataset = tooltipItem.dataset;
                        const index = tooltipItem.dataIndex;
                        const value = dataset.data[index];
                        return `${value}명`;
                    }
                }
            }
        },
        // 레이블 숨기기
        elements: {
            arc: {
                borderWidth: 2,
                borderColor: '#FFFFFF'
            }
        }
    }
});



let postCategotyValue = [372, 115, 23]; //전체 회원이 487명이라고 가정
const categoryChart = new Chart(postCategoryChart, {
    type: 'doughnut',
    data: {
        labels: ["자유글", "공략글", "파티모집"],
        datasets: [{
            backgroundColor: ["rgb(0, 255, 98)", "rgb(38, 0, 255)", "rgb(0, 0, 0)"], // 각 티어별 색상 지정
            data: postCategotyValue // 실제 데이터 삽입
        }]
    },
    options: {
        responsive: false,
        // 레전드 숨기기
        plugins: {
            legend: {
                display: false
            },
            tooltip: {
                backgroundColor: "rgb(0, 0, 0)",
                titleFont: { size: 15 },
                bodyFont: { size: 20 },
                titleColor: '#FFFFFF',
                bodyColor: "rgb(255, 255, 255)",
                borderWidth: 3,
                padding: 15,
                displayColors: true,
                callbacks: {
                    label: function (tooltipItem) {
                        const dataset = tooltipItem.dataset;
                        const index = tooltipItem.dataIndex;
                        const value = dataset.data[index];
                        return `${value}게시글`;
                    }
                }
            }
        },
        // 레이블 숨기기
        elements: {
            arc: {
                borderWidth: 2,
                borderColor: '#FFFFFF'
            }
        }
    }
});
