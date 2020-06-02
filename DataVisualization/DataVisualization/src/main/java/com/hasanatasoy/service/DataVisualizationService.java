package com.hasanatasoy.service;

import com.hasanatasoy.enums.Chart;
import com.hasanatasoy.html.HtmlContainer;
import com.hasanatasoy.model.DataModel;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class DataVisualizationService {

    private String filePath;

    public DataVisualizationService(String filePath){
        this.filePath = filePath+"/DataVisualization";
        createFileDirectory(this.filePath);
    }

    private void createFileDirectory(String filePath){
        Path path = Paths.get(filePath);
        try {
            if(!Files.exists(path))
                Files.createDirectory(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToHtmlFile(String visualizaName, List<String> data, List<Chart> charts){
        Path path = Paths.get("/"+filePath+"/"+visualizaName+".html");
        HtmlContainerService service = new HtmlContainerService();
        String jsonData = service.convertDataToJson(data);
        List<String> chartsList = charts.stream().map(Objects::toString).collect(Collectors.toList());
        String jsonCharts = service.convertDataToJson(chartsList);
        HtmlContainer htmlContainer = new HtmlContainer();
        htmlContainer.setData(jsonData);
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
            }
            Files.write(path, (htmlContainer.getJavaScriptCode()+htmlContainer.getData()+
                    htmlContainer.getJavaScriptCodePart1()+jsonCharts+htmlContainer.getJavaScriptCodePart2()).getBytes());
            Files.write(path, (htmlContainer.getHtmlCode()
                    +htmlContainer.getJavaScriptCode()
                    +htmlContainer.getData()
                    +htmlContainer.getJavaScriptCodePart1()
                    +jsonCharts+htmlContainer.getJavaScriptCodePart2()
                    +htmlContainer.getHtmlLastPart()).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void visualize(Object data, String visualizeName) {
        List<String> preparedData = new ArrayList<>();
        List<Chart> charts = new ArrayList<>();
        if(data instanceof List) {
            ((List) data).forEach(per -> {
                preparedData.add(getDataForObject(per).getData());
            });
            charts = getDataForObject(((List) data).get(0)).getCharts();
        }
        else {
            preparedData.add(getDataForObject(data).getData());
            charts = getDataForObject(data).getCharts();
        }
        writeToHtmlFile(visualizeName, preparedData, charts);
    }

    private DataModel getDataForObject(Object data){
        List<Chart> charts = getClassAnnotations(data.getClass().getAnnotations());
        StringBuilder preparedDataSB = new StringBuilder("");
        String dataRow = prepareDataRow(data);
        String dataColumn = prepareDataColumn(data);
        preparedDataSB.append(dataRow);
        preparedDataSB.append(" ");
        preparedDataSB.append(dataColumn);
        String preparedData = preparedDataSB.toString();
        return new DataModel(preparedData, charts);
    }

    private String prepareDataColumn(Object data) {
        StringBuilder stringBuilder = new StringBuilder("");
        Field[] fields = data.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            for (Annotation declaredAnnotation : field.getDeclaredAnnotations()) {
                String[] annotationParts = declaredAnnotation.toString().split("\\.");
                String annotation = annotationParts[annotationParts.length-1];
                boolean isColumn = annotation.equals("MultipleData()") || annotation.equals("SingleData()");
                if(isColumn) {
                    try {
                        if (field.get(data) instanceof List){
                            List<Integer> datas = (List<Integer>) field.get(data);
                            datas.forEach(per -> {
                                stringBuilder.append(per);
                                stringBuilder.append(" ");
                            });
                            stringBuilder.deleteCharAt(stringBuilder.toString().length()-1);
                            return stringBuilder.toString();
                        }
                        stringBuilder.append(field.get(data));
                        stringBuilder.append(" ");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.toString().length()-1);
        return stringBuilder.toString();
    }

    private String prepareDataRow(Object data) {
        StringBuilder stringBuilder = new StringBuilder("");
        Field[] fields = data.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            for (Annotation declaredAnnotation : field.getDeclaredAnnotations()) {
                String[] annotationParts = declaredAnnotation.toString().split("\\.");
                String annotation = annotationParts[annotationParts.length-1];
                boolean isRow = annotation.equals("DataName()");
                if(isRow) {
                    try {
                        stringBuilder.append(field.get(data));
                        stringBuilder.append("-");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.toString().length()-1);
        return stringBuilder.toString();
    }

    private List<Chart> getClassAnnotations(Annotation[] annotations) {
        List<Chart> charts = new ArrayList<>();
        for (Annotation annotation : annotations) {
            String[] annotationParts = annotation.toString().split("\\.");
            String annotationName = annotationParts[annotationParts.length-1];
            if(annotationName.startsWith(Chart.All.toString())){
                charts.add(Chart.All);
                return charts;
            }
            else{
                if(annotationName.startsWith(Chart.Bar.toString()))
                    charts.add(Chart.Bar);
                if(annotationName.startsWith(Chart.Line.toString()))
                    charts.add(Chart.Line);
                if(annotationName.startsWith(Chart.Donut.toString()))
                    charts.add(Chart.Donut);
                if(annotationName.startsWith(Chart.PolarArea.toString()))
                    charts.add(Chart.PolarArea);
                if (annotationName.startsWith(Chart.Radar.toString()))
                    charts.add(Chart.Radar);
            }
        }
        return charts;
    }

}
