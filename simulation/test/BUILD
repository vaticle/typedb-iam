#
# Copyright (C) 2022 Vaticle
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU Affero General Public License as
# published by the Free Software Foundation, either version 3 of the
# License, or (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Affero General Public License for more details.
#
# You should have received a copy of the GNU Affero General Public License
# along with this program.  If not, see <https://www.gnu.org/licenses/>.
#

load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_test")
load("@vaticle_dependencies//tool/checkstyle:rules.bzl", "checkstyle_test")
load("@vaticle_bazel_distribution//artifact:rules.bzl", "artifact_extractor")

artifact_extractor(
    name = "typedb-extractor-linux",
    artifact = "@vaticle_typedb_artifact_linux//file",
)

artifact_extractor(
    name = "typedb-cluster-extractor-linux",
    artifact = "@vaticle_typedb_cluster_artifact_linux//file",
)

kt_jvm_test(
    name = "comparison",
    srcs = ["ComparisonTest.kt"],
    test_class = "com.vaticle.typedb.iam.simulation.test.ComparisonTest",
    deps = [
        "//simulation/common",
        "//simulation/typedb",
        "//simulation/neo4j",

        # External Maven Dependencies
        "@maven//:info_picocli_picocli",
        "@maven//:junit_junit",
    ],
    size = "enormous",
    resource_strip_prefix = "simulation/config/",
    resources = ["//simulation/config:logback.xml"],
    data = [":comparison-test.yml"],
)

checkstyle_test(
    name = "checkstyle",
    include = glob(["*"]),
    license_type = "agpl-header",
)
