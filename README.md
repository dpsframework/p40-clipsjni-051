# P40-CLIPS-JNI-051

date:  '2022-04-27'
modified:  '2022-08-14'
status:  'In process'



## `CLIPSJNI`-0.51 for Expert Systems Tool `CLIPS-6.31`
#### CLIPS Expert System Tool `C Language Integrated Production System`)



#  Solicitud de especificación de CLIPS JNI v0.51 (Interfaz nativa de Java)
#### Propuesta de modificación de CLIPS-JNI-0.51 para detectar la arquitectura de la máquina en tiempo de ejecución y opciones de seguridad adicionales


- Resumen: Propuesta de especificación del proyecto CLIPS JNI (interfaz nativa de Java) v0.51. Esta propuesta aporta una modificación de CLIPS-JNI-0.51 para detectar la arquitectura de la máquina en tiempo de ejecución y otras opciones adicionales  de seguridad. Esta versión aporta una integración más estable entre los Agentes de Resolución de Problemas PS-Agents para JADE, y los sistemas expertos desarrollados para la versión de CLIPS 6.31 que esos agentes ejecutan.


---


[English README](README_en.md)

# CLIPS JNI v0.51 (Java Native Interface) Specification Request

## A modification of CLIPS-JNI-0.51 to detect the architecture of the machine at runtime and additional security options.



- Abstract: CLIPS JNI (Java Native Interface) Project Specification Proposal v0.51. This proposal provides a modification of CLIPS-JNI-0.51 to detect the architecture of the machine at runtime and other additional security options. This version provides a more stable integration between the PS-Agents for JADE Problem Solving Agents, and the expert systems developed for the CLIPS 6.31 version that these agents run.


---



##   Sección 2: Actualización propuesta
-  La interfaz nativa de Java CLIPS-JNI version 0.51 para CLIPS 6.31 ha sido revisada por _Gary Riley_ el pasado 2019-08-06. El código fuente está disponible en Source forge, en <https://sourceforge.net/projects/clipsrules/files/CLIPS/6.31/>.
-  Los agentes JADE con capacidades de integrar y ejecutar Sistemas Expertos autónomos sobre la plataforma Multi-Agente, requieren conocer de antemano cuál es la arquitectura de la máquina Java y del hardware donde se ejecutan. 

###  2.1. Descripción de la propuesta:

-  Realizar un desarrollo sobre CLIPS-JNI-0.51 para que esa interfaz detecte cuál es la máquina de Java y la arquitectura hardware de nodo donde se ejecuta el sistema Multi-Agente, y de esa forma, la propia Librería CLIPSJNI asocie y enlace con su librería nativa en C++.
-  El desarrollo de los elementos de seguridad adicionales, se realizó mediante el ajuste de la visibilidad de los Objetos fundamentales que componen la librería CLIPS-JNI-0.51

###  2.2. Plataforma de destino
-  Java JDK-11 hasta JDK-18. OpenJDK-18. CLIPS 6.31
  
-  Agentes de Resolución de Problemas de JADE, version 1.9 o superior.




###  2.3. ¿Qué necesita la propuesta de para su ejecución?
-  ECLIPSE IDE 2022. 
-  CLIPS 6.31 código-fuente. CLIPS-JNI-0.51 código-fuente.
-  Agentes PS de JADE version 1.9 o superior.


###  2.4. ¿Por qué esta propuesta?
-  Porque la librería dpsAgents-1.8-full.jar, desarrollada para JAVA 1.8, no es capaz de enlazar los sistemas expertos autónomos de los agentes JADE, con el núcleo de CLIPS 6.31, ni tampoco con CLIPS 6.40.
-  Porque el mecanismo de detección y enlace entre el Agente y CLIPS o Prolog, debe realizarse por parte de la librería nativa, en un enlace temprano, eliminando del agente la necesidad de localizar la ubicación de la Librería Nativa para OS-X, Gnu-Linux, Windows 32bits o Windows 64bits.






###  2.5. Tecnología o tecnologías subyacentes:
-  CLIPS
-  COOL
-  Java
-  Lisp








###  2.6. ¿Nombre de la librería generada?
-    clipsjni-051-i586.jar
-    clipsjni-051-amd64.jar
etc.








##   Sección 3: Contribuciones




###  3.1. Documentos, propuestas o implementaciones que describen la tecnología.















###  3.2. Punto de partida de la obra.
-   CLIPSJNI-051 en Source Forge en: https://sourceforge.net/projects/clipsrules/files/CLIPS/6.31/clips_jni_051.tar.gz/download













