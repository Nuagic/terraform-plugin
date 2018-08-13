package org.jenkinsci.plugins.terraform.TerraformBuildWrapper;

f = namespace('/lib/form')


f.block() {
    f.div(style: "margin: 0px 0px") {
        f.table(style: "width: 100%") {
            f.entry(field: 'terraformInstallation', title: _('Terraform Installation')) {
                f.select();
            }

            f.entry(field:'doInit', title: _('Init terraform'), description: 'Run terraform init') {
                f.checkbox();
            }

            f.entry(field:'doGet', title: _('Get modules'), description: 'Run terraform get') {
                f.checkbox();
            }

            f.entry(field:'doGetUpdate', title: _('Update modules'), description: 'Run terraform get with -update flag') {
                f.checkbox();
            }

            f.entry(field:'doPlan', title: _('Get Plan'), description: 'Run terraform plan') {
                f.checkbox();
            }

            f.entry(field:'doApply', title: _('Apply'), description: 'Run terraform apply') {
                f.checkbox();
            }

            f.entry(field: 'doDestroy', title: _('Destroy On Build Completion'), description: 'Run destroy command to delete infrastructure on build completion') {
                f.checkbox();
            }

            f.radioBlock(checked: descriptor.isInlineConfigChecked(instance), name: 'config', value: 'inline', title: 'Configuration Text') {
                f.entry(title: 'Terraform Text Configuration', field: 'inlineConfig', description: 'Inline configuration') {
                    f.textarea();
                }
            }
            f.radioBlock(checked: descriptor.isFileConfigChecked(instance), name: 'config', value: 'file', title: 'Configuration Path') {
                f.entry(title: 'Terraform File Configuration', field: 'fileConfig', description: 'Relative Path to workspace directory containing configuration files') {
                    f.textbox();
                }
            }

            f.entry(field: 'variables', title: _('Resource Variables (Optional)'), description: 'Resource variables will be passed to Terraform as a file') {
                f.textarea();
            }
        }
    }
}
