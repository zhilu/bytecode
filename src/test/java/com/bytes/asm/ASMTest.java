package com.bytes.asm;

import com.bytes.asm.util.ByteCodeUtils;
import org.junit.Test;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.RETURN;

public class ASMTest {

    @Test
    public void testHelloWorld() throws Exception {
        ClassWriter classWriter = new ClassWriter(0);

        String className = "com.bytes.asm.Test";
        String signature = "L" + className.replace(".", "/") + ";";

        // 类名、父类名、实现的接口名，以"/"替换'.'，注意，不是填类型签名
        classWriter.visit(Opcodes.V1_8, ACC_PUBLIC, className.replace(".", "/"),
                signature, "java/lang/Object", null);

        createConstructor(classWriter);

        createSayHello(classWriter);




        byte[] byteCode = classWriter.toByteArray();
        Class<?> asmGenerateClass = ByteCodeUtils.loadClass(className, byteCode);
        try {
            asmGenerateClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        ByteCodeUtils.savaToFile(className, byteCode);
    }

    private void createSayHello(ClassWriter cw) {
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "sayHello", "()V", null, null);

        mv.visitFieldInsn(GETSTATIC, Type.getInternalName(System.class), "out",
                Type.getDescriptor(System.out.getClass()));
        mv.visitLdcInsn("hello word!");
        mv.visitMethodInsn(INVOKEVIRTUAL, Type.getInternalName(System.out.getClass()), "println",
                "(Ljava/lang/String;)V", false);
        mv.visitMaxs(2,1);
        mv.visitInsn(RETURN);
    }

    static void createConstructor(ClassWriter classWriter) {
        MethodVisitor methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);

        // 调用父类构造器
        methodVisitor.visitVarInsn(ALOAD, 0);
        methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        methodVisitor.visitInsn(RETURN);

        methodVisitor.visitMaxs(1, 1);
    }
}
