package pl.kalisz.kamil;

import java.io.Serializable;
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
public class FieldAnnotationInfo<V extends Annotation> implements Serializable
{
    Field field;

    V annotation;

    public FieldAnnotationInfo(Field field, V annotation) {
        this.field = field;
        this.annotation = annotation;
    }

    public Field getField()
    {
        return field;
    }

    public V getAnnotation()
    {
        return annotation;
    }
}
