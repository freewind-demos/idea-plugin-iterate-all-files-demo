package actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileVisitor

class HelloAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        val baseDir = event.project!!.baseDir
        VfsUtilCore.visitChildrenRecursively(baseDir, object : VirtualFileVisitor<VirtualFile>() {
            override fun visitFile(file: VirtualFile): Boolean {
                println("file: $file")
                return true
            }
        })
    }

}