package com.hasanatasoy.html;

import javax.swing.*;
import java.util.List;

public class HtmlContainer {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HtmlContainer{" +
                "data=" + data +
                '}';
    }

    public String getHtmlCode() {
        return htmlCode;
    }

    public String getJavaScriptCode() {
        return javaScriptCode;
    }

    public String getJavaScriptCodePart2() {
        return javaScriptCodePart2;
    }

    public String getJavaScriptCodePart1() {
        return javaScriptCodePart1;
    }

    private String javaScriptCode =
            "<script>var result = ";
    private String javaScriptCodePart1 =
            ";\nvar charts= ";
    private String javaScriptCodePart2 =
            ";\nvar labels = [];\n" +
            "var data = [];\n" +
            "var dataSize = result[0].split(' ').length;\n" +
            "for (let index = 0; index < dataSize-1; index++) {\n" +
            "      var datasData = [];\n" +
            "      data.push(datasData);\n" +
            "}\n" +
            "for (var i = 0; i < result.length; i++) {\n" +
            "      var array = result[i].split(' ');\n" +
            "      for (var j = 0; j < array.length; j++) {\n" +
            "           if(array[j] == ''){\n" +
            "                 console.log('empty data');\n" +
            "           }\n" +
            "           if(j == 0){\n" +
            "                 labels.push(array[j]);\n" +
            "           }\n" +
            "           else{\n" +
            "                 data[j-1].push(array[j]);\n" +
            "           }\n" +
            "      }\n" +
            "}\n" +
            "\n" +
            "loadChart(data, labels, charts);\n" +
            "function createCartWith(canvasId){\n" +
            "    var container = document.getElementById('container');\n" +
            "    var cart = prepareDiv('card text-white bg-light mb-3');\n" +
            "    container.appendChild(cart);\n" +
            "    var cartHeader = prepareDiv('card-header');\n" +
            "    cart.appendChild(cartHeader);\n" +
            "    var saveButton = prepareSaveButton(canvasId);\n" +
            "    cartHeader.appendChild(saveButton);\n" +
            "    var cartBody = prepareDiv('card-body');\n" +
            "    cart.appendChild(cartBody);\n" +
            "    var canvas = prepareCanvas(canvasId);\n" +
            "    cartBody.appendChild(canvas);\n" +
            "}" +
            "\n" +
            "function prepareCanvas(id){\n" +
            "    var canvas = document.createElement('canvas');\n" +
            "    canvas.setAttribute('id', id);\n" +
            "    return canvas;\n" +
            "}\n" +
            "\n" +
            "function prepareSaveButton(chartType){\n" +
            "    var button = document.createElement('button');\n" +
            "    var classValue = 'btn btn-success';\n" +
            "    onClickValue = 'saveOnClick(\"'+chartType+'\")';\n" +
            "    button.innerHTML = 'Save';\n" +
            "    button.setAttribute('class', classValue);\n" +
            "    button.setAttribute('onClick', onClickValue);\n" +
            "    return button;\n" +
            "}\n" +
            "\n" +
            "function prepareDiv(classValue){\n" +
            "    var element = document.createElement('div');\n" +
            "    element.setAttribute('class', classValue);\n" +
            "    return element;\n" +
            "}\n" +
            "\n" +
            "function saveOnClick(id){\n" +
            "    var canvas = document.getElementById(id);\n" +
            "    canvas.toBlob(function(blob){\n" +
            "        saveAs(blob, id+'.jpg');\n" +
            "    }, 'image/jpg');\n" +
            "}" +
            "\n" +
            "function random_rgba(alpha) {\n" +
            "    var o = Math.round, r = Math.random, s = 255;\n" +
            "    return 'rgba(' + o(r()*s) + ',' + o(r()*s) + ',' + o(r()*s) + ','+alpha+')';\n" +
            "}" +
            "\n" +
            "function randomKey(){\n" +
            "    var chars = [\"0\",\"1\",\"2\",\"3\",\"4\",\"5\",\"6\",\"7\",\"8\",\"9\"];\n" +
            "    var o = Math.round, r= Math.random;\n" +
            "    var randomKey= \"\";\n" +
            "    var randomNumber = 0;\n" +
            "    for (let index = 0; index < 18; index++) {\n" +
            "        randomNumber = o(r()*9);\n" +
            "        console.log(randomNumber);\n" +
            "        randomKey = randomKey + chars[randomNumber];\n" +
            "    }\n" +
            "    return randomKey;\n" +
            "}" +
            "\n" +
            "function loadChart(data, label, charts){\n" +
                    "    var randomId;\n" +
                    "    charts.forEach(chart => {\n" +
                    "        if(chart == \"All\"){\n" +
                    "            loadAllCharts(data, label);\n" +
                    "        }\n" +
                    "        else if(chart == \"Line\"){\n" +
                    "            randomId = randomKey();\n" +
                    "            createCartWith(randomId);\n" +
                    "            loadLineChart(data,label,randomId);\n" +
                    "        }\n" +
                    "        else if(chart == \"Bar\"){\n" +
                    "            randomId = randomKey();\n" +
                    "            createCartWith(randomId);\n" +
                    "            loadBarChart(data,label, randomId);\n" +
                    "        }\n" +
                    "        else if(chart == \"PolarArea\"){\n" +
                    "            randomId = randomKey();\n" +
                    "            createCartWith(randomId);\n" +
                    "            loadPolarArea(data, label, randomId);\n" +
                    "        }\n" +
                    "        else if(chart == \"Radar\"){\n" +
                    "            randomId = randomKey();\n" +
                    "            createCartWith(randomId);\n" +
                    "            loadRadarChart(data, label, randomId)\n" +
                    "        }\n" +
                    "        else if(chart == \"Donut\"){\n" +
                    "            randomId = randomKey();\n" +
                    "            createCartWith(randomId);\n" +
                    "            loadDonutChart(data, label, randomId);\n" +
                    "        }\n" +
                    "        else{\n" +
                    "            Message.box(\"Lutfen Chart Belirtiniz\")\n" +
                    "        }\n" +
                    "    })\n" +
                    "}\n" +
                    "\n" +
                    "function loadAllCharts(data, label){\n" +
                    "    var randomId;\n" +
                    "    randomId = randomKey();\n" +
                    "    createCartWith(randomId);\n" +
                    "    loadLineChart(data,label,randomId);     \n" +
                    "    randomId = randomKey();\n" +
                    "    createCartWith(randomId);\n" +
                    "    loadBarChart(data,label, randomId);\n" +
                    "    randomId = randomKey();\n" +
                    "    createCartWith(randomId);\n" +
                    "    loadPolarArea(data, label, randomId);\n" +
                    "    randomId = randomKey();\n" +
                    "    createCartWith(randomId);\n" +
                    "    loadRadarChart(data, label, randomId)\n" +
                    "    randomId = randomKey();\n" +
                    "    createCartWith(randomId);\n" +
                    "    loadDonutChart(data, label, randomId);\n" +
                    "}" +
            "\n" +
            "function loadLineChart(data, label, id){\n" +
            "    var lineChart = document.getElementById(id)\n" +
            "    var datasets = [];\n" +
            "    var counter = 0;\n" +
            "    data.forEach(element => {\n" +
            "        var instance = {\n" +
            "            label: \"Data \"+(++counter),\n" +
            "            data: element,\n" +
            "            fill: false,\n" +
            "            borderColor: random_rgba(0.75),\n" +
            "            backgroundColor: 'transparent',\n" +
            "            pointBackgroundColor: 'white',\n" +
            "            pointRadius: 5,\n" +
            "            pointHoverRadius: 10,\n" +
            "            pointStyle: 'circle'\n" +
            "          }\n" +
            "        datasets.push(instance);\n" +
            "    })\n" +
            "    var data = {\n" +
            "        labels: label,\n" +
            "        datasets: datasets\n" +
            "      };\n" +
            "    \n" +
            "      var myLineChart = new Chart(lineChart, {\n" +
            "        type: 'line',\n" +
            "        data: data,\n" +
            "        options: {\n" +
            "            scales: {\n" +
            "                yAxes: [{\n" +
            "                    ticks: {\n" +
            "                        beginAtZero: true\n" +
            "                    }\n" +
            "                }]\n" +
            "            }\n" +
            "        }\n" +
            "    });\n" +
            "}" +
            "\n" +
            "function loadBarChart(data, label, id){ \n" +
            "    var barChart = document.getElementById(id);\n" +
            "    var datasets = [];\n" +
            "    var counter = 0;\n" +
            "    data.forEach(element => {\n" +
            "        var instance = {\n" +
            "            label: \"Data \"+(++counter),\n" +
            "            backgroundColor: random_rgba(0.75),\n" +
            "            data: element\n" +
            "        }\n" +
            "        datasets.push(instance);\n" +
            "    })\n" +
            "    var data = {\n" +
            "        labels: label,\n" +
            "        datasets: datasets\n" +
            "    };\n" +
            "    var myBarChart = new Chart(barChart, {\n" +
            "        type: 'horizontalBar',\n" +
            "        data: data,\n" +
            "        options: {\n" +
            "            barValueSpacing: 20,\n" +
            "            scales: {\n" +
            "                xAxes: [{\n" +
            "                    ticks: {\n" +
            "                        min: 0\n" +
            "                    }\n" +
            "                }]\n" +
            "            }\n" +
            "        }\n" +
            "    });\n" +
            "}\n" +
            "\n" +
            "function loadPolarArea(data, label, id){\n" +
            "    var datasets = [];\n" +
            "    var backgroundColor = [];\n" +
            "    data[0].forEach(el => {\n" +
            "        backgroundColor.push(random_rgba(0.5));\n" +
            "    })\n" +
            "    data.forEach(element => {\n" +
            "        var instance = {\n" +
            "            data: element,\n" +
            "            backgroundColor: backgroundColor\n" +
            "        };\n" +
            "        datasets.push(instance);\n" +
            "    })\n" +
            "    data = {\n" +
            "        labels: label,\n" +
            "        datasets: datasets\n" +
            "    };\n" +
            "    var polarAreaChart = document.getElementById(id);\n" +
            "    var polarChart = new Chart(polarAreaChart, {\n" +
            "        data: data,\n" +
            "        type: 'polarArea'\n" +
            "    });\n" +
            "}\n" +
            "\n" +
            "function loadRadarChart(data, label, id){\n" +
            "    var datasets = [];\n" +
            "    var counter = 0;\n" +
            "    data.forEach(element => {\n" +
            "        var data = {\n" +
            "            label: \"Data \"+(++counter),\n" +
            "            data: element,\n" +
            "            backgroundColor: random_rgba(0.1)\n" +
            "        };\n" +
            "        datasets.push(data);\n" +
            "    })\n" +
            "    data = {\n" +
            "        labels: label,\n" +
            "        datasets: datasets\n" +
            "    };\n" +
            "    var radarChart = document.getElementById(id);\n" +
            "    var myRadarChart = new Chart(radarChart, {\n" +
            "        data: data,\n" +
            "        type: 'radar',\n" +
            "        options: {\n" +
            "            scale: {\n" +
            "                angleLines: {\n" +
            "                    display: false\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    });\n" +
            "}\n" +
            "function loadDonutChart(data, label, id){\n" +
            "    var donutChart = document.getElementById(id);\n" +
            "    var datasets = [];\n" +
            "    var backgroundColor = [];\n" +
            "    data[0].forEach(el => {\n" +
            "        backgroundColor.push(random_rgba(0.75));\n" +
            "    })\n" +
            "    data.forEach(element => {\n" +
            "        var instance = {\n" +
            "            backgroundColor: backgroundColor,\n" +
            "            data: element\n" +
            "        }\n" +
            "        datasets.push(instance);\n" +
            "    })\n" +
            "    var data = {\n" +
            "        labels: label,\n" +
            "        datasets: datasets\n" +
            "    };\n" +
            "    var myDonutChart = new Chart(donutChart, {\n" +
            "        type: 'doughnut',\n" +
            "        data: data,\n" +
            "    });\n" +
            "}</script>" ;

    private String htmlCode = "<!DOCTYPE html>\n" +
            "<html lang='en'>\n" +
            "    <head>\n" +
            "        <meta charset='UTF-8'>\n" +
            "        <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
            "        <meta http-equiv='X-UA-Compatible' content='ie=edge'>\n" +
            "        <title>Data Visualization</title>\n" +
            "\n" +
            "        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'\n" +
            "            integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>\n" +
            "\n" +
            "        <style>\n" +
            "              body{\n" +
            "                   background-color: #f0f2f5;\n" +
            "              }\n" +
            "              .bg-light{\n" +
            "                   background-color: white !important;\n" +
            "              }\n" +
            "              .navbar-brand{\n" +
            "                   margin-left: 45px;\n" +
            "              }\n" +
            "              .container-flud{\n" +
            "                   margin-left: 25px;\n" +
            "                   margin-right: 25px;\n" +
            "                   padding: 15px;\n" +
            "              }\n" +
            "              .lineDiv{\n" +
            "                   width: 100%;\n" +
            "                   margin-top: 15px;\n" +
            "                   padding: 35px;\n" +
            "              }\n" +
            "              .polarAreaDiv{\n" +
            "                   width: 700px;\n" +
            "                   height: auto;\n" +
            "                   padding-top: 15px;\n" +
            "              }\n" +
            "              .barChartDiv{\n" +
            "                   width: 700px;\n" +
            "                   height: auto;\n" +
            "                   padding-top: 15px;\n" +
            "              }\n" +
            "              .sub-chart{\n" +
            "                   display: flex;\n" +
            "                   justify-content: space-between;\n" +
            "                   margin-top: 25px;\n" +
            "              }\n"+
            "        </style>\n" +
            "    </head>\n" +
            "    <body>\n" +
            "        <nav class='navbar navbar-light bg-light' style='background-color: white;'>\n" +
            "            <a class='navbar-brand' href='#'>Data Visualization</a>\n" +
            "        </nav>\n" +
            "        <div class='container' id='container'>\n" +
            "        </div>\n" +
            "        <script src='https://code.jquery.com/jquery-3.3.1.slim.min.js'\n" +
            "            integrity='sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo'\n" +
            "            crossorigin='anonymous'></script>\n" +
            "        <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js'\n" +
            "            integrity='sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1'\n" +
            "            crossorigin='anonymous'></script>\n" +
            "        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js'\n" +
            "            integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM'\n" +
            "            crossorigin='anonymous'></script>\n" +
            "        <script src='https://cdn.jsdelivr.net/npm/chart.js@2.8.0'></script>\n" +
            "        <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>\n" +
            "        <script src='https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/1.3.3/FileSaver.min.js'></script>\n" +
            "        ";
    private String htmlLastPart = "    </body>\n" +
            "</html>";

    public String getHtmlLastPart() {
        return htmlLastPart;
    }
}
