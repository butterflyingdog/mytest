provider "alicloud" {}

resource "alicloud_vpc" "vpc" {
  name       = "tf_test_foo"
  cidr_block = "172.16.0.0/12"
}

resource "alicloud_vswitch" "vsw" {
  vpc_id            = alicloud_vpc.vpc.id
  cidr_block        = "172.16.0.0/21"
  availability_zone = "cn-hangzhou-b"
}


resource "alicloud_security_group" "default" {
  name = "default"
  vpc_id = alicloud_vpc.vpc.id
}

resource "alicloud_instance" "instance" {
  # 可用区
  availability_zone = "cn-hangzhou-b"
  # 绑定安全组
  security_groups = alicloud_security_group.default.*.id

  # 实例规格
  instance_type        = "ecs.n2.small"
  # 系统盘类型
  system_disk_category = "cloud_efficiency"
  # 系统镜像
  image_id             = "ubuntu_140405_64_40G_cloudinit_20161115.vhd"
  # 实例名称
  instance_name        = "test_foo"
  # 所在交换机
  vswitch_id = alicloud_vswitch.vsw.id
  # 公网带宽
  internet_max_bandwidth_out = 10
}

resource "alicloud_security_group_rule" "allow_all_tcp" {
  type              = "ingress"
  ip_protocol       = "tcp"
  nic_type          = "intranet"
  policy            = "accept"
  port_range        = "1/65535"
  priority          = 1
  security_group_id = alicloud_security_group.default.id
  cidr_ip           = "0.0.0.0/0"
}