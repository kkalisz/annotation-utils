package pl.kalisz.kamil;


import android.support.v4.util.LruCache;

import java.lang.annotation.Annotation;

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
public class AnnotationUtils
{
    public static final int DEFAULT_CACHE_SIZE = 30;
    
    private static LruCache<Class, ClassAnnotationMap> annotationsCache = new LruCache<Class, ClassAnnotationMap>(DEFAULT_CACHE_SIZE)
    {
        @Override
        protected ClassAnnotationMap create(Class key)
        {
            return new ClassAnnotationMap(key);
        }
    };

    /**
     *
     * @param sourceClass from it we read fields and annotations
     * @param annotationClass for this class there will be builded {@link pl.kalisz.kamil.FieldAnnotationMap}
     * @param <V> type of annotation
     * @return {@link pl.kalisz.kamil.FieldAnnotationMap} for {@link V} and recursively for all superclasses of {@link V}

     */
    public static <V extends Annotation> FieldAnnotationMap<V> getFieldAnnotations(Class sourceClass, Class<V> annotationClass)
    {
        FieldAnnotationMap<V> fieldAnnotationMap = new FieldAnnotationMap<V>();
        while (sourceClass != null)
        {
            ClassAnnotationMap classAnnotationMap = annotationsCache.get(sourceClass);
            fieldAnnotationMap.add(classAnnotationMap.getFieldAnnotationMap(annotationClass));
            sourceClass = sourceClass.getSuperclass();
        }
        return fieldAnnotationMap;
    }
    
    public static void setMaxCacheSize(int cacheSize)
    {
        annotationsCache.trimToSize(cacheSize);
    }
    
    public static int getMaxCacheSize()
    {
        return annotationsCache.maxSize();
    }

    public static void clear()
    {
        annotationsCache.evictAll();
    }

}
