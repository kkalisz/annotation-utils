package pl.kalisz.kamil;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/*
 * Copyright (C) 2014 Kamil Kalisz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class AnnotationExtractor
{

    /**
     * @param sourceClass from it we read fields and annotations
     * @param annotationClass for this class there will be builded {@link pl.kalisz.kamil.FieldAnnotationMap}
     * @param <V> type of annotation
     * @return {@link pl.kalisz.kamil.FieldAnnotationMap} for {@link V} type ( only for this class no superclass data is extracted  )
     */
    public static <V extends Annotation> FieldAnnotationMap<V> extractFields(Class sourceClass, Class<V> annotationClass)
    {
        FieldAnnotationMap annotationMap = new FieldAnnotationMap();
        for (Field field : sourceClass.getDeclaredFields())
        {
            V annotation = field.getAnnotation(annotationClass);
            if (annotation != null)
            {
                annotationMap.add(new FieldAnnotationInfo(field, annotation));
            }
        }
        return annotationMap;
    }

}
