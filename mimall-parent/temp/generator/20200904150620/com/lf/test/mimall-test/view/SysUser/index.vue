<template>
    <div>
        <Card shadow>
            <div class="search-con search-con-top">
                <ButtonGroup>
                    <Button :disabled="hasAuthority('SysUserEdit')?false:true"  class="search-btn" type="primary" @click="handleModal()">
                        <span>添加</span>
                    </Button>
                </ButtonGroup>
            </div>
            <Table :columns="columns" :data="data" :loading="loading">
                <template slot="action" slot-scope="{ row }">
                    <a :disabled="hasAuthority('SysUserEdit')?false:true"   @click="handleModal(row)">
                        编辑</a>&nbsp;
                    <Dropdown v-show="hasAuthority('SysUserEdit')" transfer ref="dropdown" @on-click="handleClick($event,row)">
                        <a href="javascript:void(0)">
                            <span>更多</span>
                            <Icon type="ios-arrow-down"></Icon>
                        </a>
                        <DropdownMenu slot="list">
                            <DropdownItem  name="remove">删除</DropdownItem>
                        </DropdownMenu>
                    </Dropdown>&nbsp;
                </template>
            </Table>
            <Page :total="pageInfo.total" :current="pageInfo.page" :page-size="pageInfo.limit" show-elevator show-sizer
                  show-total
                  @on-change="handlePage" @on-page-size-change='handlePageSize'></Page>
        </Card>
        <Modal v-model="modalVisible"
               :title="modalTitle"
               width="40"
               @on-cancel="handleReset">
            <div>
                <Form ref="form" :model="formItem" :rules="formItemRules" :label-width="100">
                    <FormItem label="姓名" prop="name">
                        <Input v-model="formItem.name"  placeholder="请输入内容"></Input>
                    </FormItem>
                    <FormItem label="性别，0：男性，1：女生" prop="sex">
                        <Input v-model="formItem.sex"  placeholder="请输入内容"></Input>
                    </FormItem>
                    <FormItem label="出生日期" prop="birthday">
                        <Input v-model="formItem.birthday"  placeholder="请输入内容"></Input>
                    </FormItem>
                    <FormItem label="创建时间" prop="create_time">
                        <Input v-model="formItem.create_time"  placeholder="请输入内容"></Input>
                    </FormItem>
                    <FormItem label="创建人" prop="create_by">
                        <Input v-model="formItem.create_by"  placeholder="请输入内容"></Input>
                    </FormItem>
                    <FormItem label="更新时间" prop="update_time">
                        <Input v-model="formItem.update_time"  placeholder="请输入内容"></Input>
                    </FormItem>
                    <FormItem label="更新人" prop="update_by">
                        <Input v-model="formItem.update_by"  placeholder="请输入内容"></Input>
                    </FormItem>
                    <FormItem label="删除标记，0：未删除，1：已删除" prop="del_flag">
                        <Input v-model="formItem.del_flag"  placeholder="请输入内容"></Input>
                    </FormItem>
                </Form>
                <div class="drawer-footer">
                    <Button type="default" @click="handleReset">取消</Button>&nbsp;
                    <Button type="primary" @click="handleSubmit" :loading="saving">保存</Button>
                </div>
            </div>
        </Modal>
    </div>
</template>

<script>
    import SysUser from '@/api/SysUser'

    export default {
        name: 'SysUser',
        data () {
            return {
                loading: false,
                saving: false,
                modalVisible: false,
                modalTitle: '',
                pageInfo: {
                    total: 0,
                    page: 1,
                    limit: 10
                },
                formItemRules: {
                    name: [
                        {required: true, message: '姓名不能为空', trigger: 'blur'}
                    ],
                    sex: [
                        {required: true, message: '性别，0：男性，1：女生不能为空', trigger: 'blur'}
                    ],
                    birthday: [
                        {required: true, message: '出生日期不能为空', trigger: 'blur'}
                    ],
                    create_time: [
                        {required: true, message: '创建时间不能为空', trigger: 'blur'}
                    ],
                    create_by: [
                        {required: true, message: '创建人不能为空', trigger: 'blur'}
                    ],
                    update_time: [
                        {required: true, message: '更新时间不能为空', trigger: 'blur'}
                    ],
                    update_by: [
                        {required: true, message: '更新人不能为空', trigger: 'blur'}
                    ],
                    del_flag: [
                        {required: true, message: '删除标记，0：未删除，1：已删除不能为空', trigger: 'blur'}
                    ],
                },
                formItem: {
                    id: '',
                    name: '',
                    sex: '',
                    birthday: '',
                    create_time: '',
                    create_by: '',
                    update_time: '',
                    update_by: '',
                    del_flag: '',
                },
                columns: [
                    {
                        title: '姓名',
                        key: 'name',
                        width: 100
                    },
                    {
                        title: '性别，0：男性，1：女生',
                        key: 'sex',
                        width: 100
                    },
                    {
                        title: '出生日期',
                        key: 'birthday',
                        width: 100
                    },
                    {
                        title: '创建时间',
                        key: 'create_time',
                        width: 100
                    },
                    {
                        title: '创建人',
                        key: 'create_by',
                        width: 100
                    },
                    {
                        title: '更新时间',
                        key: 'update_time',
                        width: 100
                    },
                    {
                        title: '更新人',
                        key: 'update_by',
                        width: 100
                    },
                    {
                        title: '删除标记，0：未删除，1：已删除',
                        key: 'del_flag',
                        width: 100
                    },
                    {
                        title: '操作',
                        slot: 'action',
                        fixed: 'right',
                        width: 120
                    }
                ],
                data: []
            }
        },
        methods: {
            handleModal (data) {
                if (data) {
                    this.modalTitle = '编辑'
                    this.formItem = Object.assign({}, this.formItem, data)
                } else {
                    this.modalTitle = '添加'
                }
                this.modalVisible = true
            },
            handleReset () {
                const newData = {
                    id: '',
                    name: '',
                    sex: '',
                    birthday: '',
                    create_time: '',
                    create_by: '',
                    update_time: '',
                    update_by: '',
                    del_flag: '',
                }
                this.formItem = newData
                //重置验证
                let form  = this.$refs['form']
                form.resetFields()
                        this.modalVisible = false
                this.saving = false
            },
            handleSubmit () {
                let form  = this.$refs['form']
                form.validate((valid) => {
                    if (valid) {
                        this.saving = true
                        if (this.formItem.id) {
                        SysUser.update(this.formItem).then(res => {
                            if (res.code === 0) {
                                this.$Message.success('保存成功')
                                this.handleReset()
                             }
                            this.handleSearch()
                        }).finally(() => {this.saving = false})
                    } else {
                       SysUser.add(this.formItem).then(res => {
                            this.handleReset()
                            this.handleSearch()
                            if (res.code === 0) {
                                this.$Message.success('保存成功')
                            }
                          }).finally(() => {this.saving = false})
                        }
                   }
                })
            },
            handleSearch (page) {
                if (page) {
                    this.pageInfo.page = page
                }
                this.loading = true
                SysUser.list({page: this.pageInfo.page, limit: this.pageInfo.limit}).then(res => {
                    this.data = res.data.records
                    this.pageInfo.total = parseInt(res.data.total)
                }).finally(() => {this.loading = false})
            },
            handlePage (current) {
                this.pageInfo.page = current
                this.handleSearch()
            },
            handlePageSize (size) {
                this.pageInfo.limit = size
                this.handleSearch()
            },
            handleRemove (data) {
               let modal = this.$Modal
               modal.confirm({
                    title: '确定删除吗？',
                    onOk: () => {
                        SysUser.remove(data.id).then(res => {
                            if (res.code === 0) {
                                this.pageInfo.page = 1;
                                this.$Message.success('删除成功');
                            }
                            this.handleSearch();
                        })
                    }
                })
            },
            handleClick (name, row) {
                switch (name) {
                    case 'remove':
                        this.handleRemove(row)
                        break
                }
            }
        },
        mounted: function () {
            this.handleSearch()
        }
    }
</script>
